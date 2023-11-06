######################## Projet forecasting model ##############################
###################### MARINGER Léa, MOUTTAPA Arnaud ###########################

############################### Bibliothèques ##################################

library(fpp3)
library(ggplot2)
library(dplyr)
library(Select)
library(tsibble)
library(zoo) 
library(lmtest)
library(forecast)
library(ggplot2)
library(stats)
library(urca)
library(caschrono)
library(tseries)

################################################################################
######################## Partie 1 : Simulation #################################
################################################################################

# Fonction 1 : Simulation d'un processus ARMA(p, q)
simul_arma <- function (n, coef_ar, coef_ma, std) {
  # Retourne la concaténation de y la série simulée et e les résidus de la série
  p <- length(coef_ar)
  q <- length(coef_ma)
  set.seed(123)
  y <- e <- rnorm(n, sd = std)
  for(t in (max(p,q)+1):n) {
    for (i in 1:p) y[t] <- y[t] + coef_ar[i]*y[t-i]
    for(j in 1:q) y[t] <- y[t] + coef_ma[j]*e[t-j]
  }
  return(c(y,e)) # Concaténation de la série simulée et des résidus de la série
}

# Simulation d'un processus ARMA(1,3)
coef_ar <- c(0.2, 0.5)
coef_ma <- c(0.3, 0.5)
n <- 300 # Nombre d'observations générées
x <- simul_arma(n, coef_ar, coef_ma, 1)
y <- x[1: n] # Extraction de la série
e <- x[(n+1): (2*n)] # Extraction des résidus

# Affichage de y
y.ts <- ts(y) # Transformation en série temporelle
ts.plot(y.ts)

# Test de stationnarité du processus simulé
kpss_test <- ur.kpss(y)
summary(kpss_test)
# Comme attendu (etant donné notre processus (ARMA(2,2)),
# le test KPSS confirme la stationnarité du processus simulé
# (Rarement, ce n'est pas le cas, du au caractère aléatoire de la simulation)

# Séparation en données d'entrainement et données de test
y_train <- window(y.ts, end = 14*n%/%15) # 280 observations
y_test <- window(y.ts, start = 14*n%/%15+1) # 20 observations
y_test_ts <- ts(y_test)

# Fonction 2: Prévision pour un processus ARMA
forecast_arma <- function (y, e, h, coef_ar, coef_ma) {
  p <- length(coef_ar)
  q <- length(coef_ma)
  t <- length(y)
  y <- c(y,numeric(h))
  for (k in 1:h) { # Pour chaque observation à prédire
    for (i in 1:p) { # Pour chaque coefficient AR
      y[t+k] <- y[t+k-i]*coef_ar[i]
    }
    for (j in 1:q) {# Pour chaque coefficient MA
      if (j>=k) y[t+k] <- y[t+k] + e[t+k-j]*coef_ma[j]
    }
  }
  return(y[(t+1):(t+h)])
}

# Prévisions pour le processus ARMA(1,3) simulé précédent
h <- length(y_test) # Nombre de valeurs futures à prédire (20 ici)
# h doit être petit car les prévisions tendent vers 0 quand h devient grand)
pred <- forecast_arma(y_train, e, h, coef_ar, coef_ma)
pred.ts <- ts(pred)
ts.plot(pred.ts, xlab = "h", ylab = "Valeur", 
        main = paste("Prévision des", h, 
                     "futures valeurs de y selon notre algorithme de prévision")) 
# La prévision converge vers 0
# Ce qui est attendu pour un processus stationnaire 

# Estimation d'un modèle ARMA(1,3) sur notre processus simulé
x <- seq(1:h)
y.arma <- arima(y_train, order = c(2, 0, 2), include.mean = FALSE)
y.arma$coef # Coeffs AR assez bien estimés quand n est grand, coeffs MA moins
y.predict <- predict(y.arma, n.ahead = h)
y.predict_ts <- ts(y.predict$pred)
y.predict_ts
ts.plot(y.predict_ts, xlab = "h", ylab = "Valeur", 
        main = paste("Prévision des", h, 
                     "futures de y selon la méthode forecast de R"))
# La prévision converge également vers 0

# Représentation graphique des 2 prévisions
ts.plot(y_test_ts, ylim = c(-6, 6), xlab = "h", ylab = "Valeur", 
        main = "Représentation des valeurs à prévoir et des deux prévisions")
par(new = TRUE)
ts.plot(pred.ts, ylim = c(-6, 6), col = 'blue', xlab = "", ylab = "")
par(new = TRUE)
ts.plot(y.predict_ts, ylim = c(-6, 6), col = 'red', xlab = "", ylab = "")
# Les prévisions sont très similaires et tendent vers 0. 
# Les estimations ne sont pas en accord avec les valeurs, 
# ce qui peut être expliqué par l'influence du bruit blanc dans la simulation


###############################################################################
####################### Partie 2 : Revenus Google #############################
###############################################################################

################################# Données #####################################

# Lecture du jeu de données et conversion en tsibble #####
google_revenue <- read.csv("google_revenue.csv", skip = 4, sep = ";")
colnames(google_revenue) <- c("Quarter", "Revenue")
google_revenue <- google_revenue %>%
  mutate(Quarter = yearquarter(as.yearqtr(Quarter, format = "Q%q '%y"))) %>%
  mutate(Revenue = as.numeric(gsub(",", "", google_revenue$Revenue))) %>%
  as_tsibble(index = Quarter)
head(google_revenue)

# Observation graphique du jeu de données
autoplot(google_revenue, Revenue) + geom_point() +
  labs(x = "Trimestre", y = "Millions de dollars américains", 
       title = "Revenus trimestriels de Google")

# On observe une saisonnalité de 4 (chaque année)
# Il y a aussi une tendance croissante des revenus 
# Les données ne sont pas stationnaires
# De plus, on remarque une croissance beaucoup plus forte sur les années 
# 2020 et 2021.

# Séparer nos données en données d'entrainement et de test
n <- length(google_revenue$Quarter)
google_revenue_ts <- ts(google_revenue$Revenue, frequency = 4, start = c(2008, 1))
google_train_ts <- window(google_revenue_ts, end = c(2019, 1))
google_test_ts <- window(google_revenue_ts, start = c(2019, 2))
google_train <- google_revenue[1:(3*n%/%4),]
google_test <- google_revenue[((3*n%/%4)+1):n,]
length(google_train$Quarter) # 45 observations
length(google_test$Quarter) # 17 observations

############################ Modèles de référence ##############################

# Estimation des 4 modèles de référence
mable_ref <- google_train |>
  model(
    Seasonal_naive = SNAIVE(Revenue),
    Naive = NAIVE(Revenue),
    Drift = RW(Revenue ~ drift()),
    Mean = MEAN(Revenue)
  )

# Prévisions pour les 17 trimestres de l'ensemble de test
h <- length(google_test$Quarter)
ref_fc <- mable_ref |> forecast(h = h)

# Affichage des prévisions pour chaque modèle de référence
unique(ref_fc$.model)
par(mfrow = c(2, 2))
# Pour la méthode de moyenne mobile
pred_mean <- ref_fc %>% filter(.model == "Mean")
autoplot(pred_mean, google_revenue) +
  labs(x = "Trimestre", y = "Millions de dollars américains", 
       title = "Prévisions avec la méthode de la moyenne")
# Pour le modèle naif
pred_naif <- ref_fc %>% filter(.model == "Naive")
autoplot(pred_naif, google_revenue) +
  labs(x = "Trimestre", y = "Millions de dollars américains", 
       title = "Prévisions avec le modèle naif")
# Pour le modèle naif saisonnier
pred_naifsais <- ref_fc %>% filter(.model == "Seasonal_naive")
autoplot(pred_naifsais, google_revenue) + 
  labs(x = "Trimestre", y = "Millions de dollars américains", 
       title = "Prévisions avec le modèle naif saisonnier")
# Pour la méthode de la dérive
pred_drift <- ref_fc %>% filter(.model == "Drift")
autoplot(pred_drift, google_revenue) + 
  labs(x = "Trimestre", y = "Millions de dollars américains", 
       title = "Prévisions avec le modèle de la dérive")

# Comparaison des 4 méthodes 
autoplot(ref_fc, google_revenue, level = NULL) +
  labs(x = "Trimestre", y = "Millions de dollars américains", 
       title = "Prévisions avec les 4 modèles de référence")

############################# Stationnarisation ################################

# Transformation logarithmique de la série pour stabiliser la variance
google_revenue$Revenue <- log(google_revenue$Revenue)
autoplot(google_revenue, Revenue) + geom_point() + 
  labs(x = "Trimestre", y = "log(millions de dollars)", 
       title = "Revenus de Google")

# On observe que la variance est stabilisée.

# Autocorrélations et autocorrélations partielles de la série log
par(mfrow = c(2, 1))
acf <- acf(google_revenue, plot = FALSE)
pacf <- pacf(google_revenue,plot = FALSE)
acf$lag <- 4*acf$lag
pacf$lag <- 4*pacf$lag
plot(acf, main = "Fonction d'autocorrélation de la série logarithmique 
     des revenus de Google")
plot(pacf, main = "Fonction d'autocorrélation partielle de la série 
     logarithmique des revenus de Google")

# Test de stationnarité: KPPS
kpss_test <- ur.kpss(google_revenue$Revenue)
summary(kpss_test)
# La statistique vaut 1.6339,
# ce qui est supèrieure à la valeur critique à 1% 0.739
# L'hypothèse nulle est donc rejetée, la série n'est pas stationnaire
# On effectue donc une différenciation d'ordre 1 pour essayer de rendre la 
# série stationnaire

# Différenciation d'ordre 1
diff <- diff(google_revenue$Revenue)
gr_diff <- google_revenue[-1,] %>% mutate(Revenue = diff)
autoplot(gr_diff, Revenue) + 
  labs(x = "Temps",y= "log(X_t) - log(X_(t-1))",
       title = "Série différencée une fois")
# Les valeurs semblent être centrées autour de 0 et la variance semble constante.
# Maintenant nous examinons les graphes ACF et PACF

# Etude des ACF et PACF après différenciation première
par(mfrow = c(2, 1))
acf_diff <- acf(gr_diff, plot = FALSE)
pacf_diff <- pacf(gr_diff, plot = FALSE)
acf_diff$lag <- 4*acf_diff$lag
pacf_diff$lag <- 4*pacf_diff$lag  
plot(acf_diff, main = "Fonction d'autocorrélation de log(Revenus de Google 
     en fonction du temps) + différence première")
plot(pacf_diff, main = "Fonction d'autocorrélation partielle de log(Revenus de
     Google en fonction du temps) + différence première")
# On observe une corrélation saisonnière des valeurs. En effet, les lags 
# multiples de 4 ont des pics significatifs, ce qui traduit la saisonnalité
# de 4 que nous avions observé directement sur la série

# Tests de stationnarité KPSS pour la série différenciée
kpss_test <- ur.kpss(gr_diff$Revenue)
summary(kpss_test)
# Le test donne une valeur de 0.0658, ce qui est inférieur à tous les seuils
# critiques. Cela indique que la série est stationnaire.
# Cependant, la série comporte encore une saisonnalité et n'est donc
# pas stationnaire.

# Test de stationnarité ADF
adf_diff <- adf.test(gr_diff$Revenue)
adf_diff
# La statistique est plus grande que la p-value (en valeur absolue)
# Donc l'hypothèse nulle de stationnarité est rejetée.

# Différenciation saisonnière 
diff_season <- diff(gr_diff$Revenue, lag = 4)
gr_diff_season <- gr_diff[-1:-4,] %>%
  mutate(Revenue = diff_season)
autoplot(gr_diff_season, Revenue) + 
  labs(title = "log(Revenus de Google en fonction du temps) + différence saisonnière")

# Test de stationnarité sur la série diff 1 + diff saisonniere
kpss_test <- ur.kpss(gr_diff_season$Revenue)
summary(kpss_test)
# Le test donne une statistique de test de 0.0846, avec un seuil critique à 1% 
# de 0.739. L'hypothèse nulle de stationnairarité est acceptée un risque de 1% 
# de se tromper.

###################### Ajustement de différents modèles ########################

# Séparation en séries d'entrainement et de test(avec transformation log)
google_train <- google_revenue[1:(3*n%/%4),] # 45 observations
google_test <- google_revenue[((3*n%/%4)+1):n,] # 17 observations
# Et en ts:
google_test_ts <- ts(google_test)

# ACF et PACF sur la série avec diff et diff saisonnières
par(mfrow = c(2, 1))
acf_season <- acf(gr_diff_season, plot = FALSE)
pacf_season <- pacf(gr_diff_season, plot = FALSE)
acf_season$lag <- 4*acf_season$lag
pacf_season$lag <- 4*pacf_season$lag
plot(acf_season, main = "Fonction d'autocorrélation de log(Revenus de Google 
     en fonction du temps) + différence saisonnière ")
plot(pacf_season, main = "Fonction d'autocorrélation partielle de log(Revenus 
     de Google en fonction du temps) + différence saisonnière")
# Les deux fonctions d'autocorrélation convergent vers 0
# ACF: 1 seule autocorrélation partielle significative: ordre 4 (pèriode)
# PACF: 1 seule autocorréaltion significative: ordre 4 (pèriode)
# On va donc d'abord considérer le modèle ARIMA(0,1,0)(1,1,1)_4

# Modèle 1: ARIMA(0,1,0)(1,1,1)_4
model1 <- arima(google_train$Revenue, order = c(0, 1, 0), 
               seasonal = list(order = c(1, 1, 1), period = 4))
model1
t_stat(model1)
# Le coefficient sar1 n'est pas significatif car la p-valeur est supérieure 
# à 0.05 (hypothèse nulle : le coefficient n'est pas significatif).
# Pour le coefficient sma1, on rejette l'hypothèse nulle que le coefficient
# n'est pas significatif, donc le coefficient est significatif.
# On va donc considérer le modèle sans le coefficient non significatif

# Test sur résidus du modèle 1
ljung_box(model1$residuals)
# Les résidus sont non corrélés (hypothèse nulle du test : les résidus ne sont 
# pas corrélés)
shapiro.test(model1$residuals)
# Les résidus suivent une loi bruit blanc gaussien 

# Modèle 2: ARIMA(0,1,0)(0,1,1)_4
model2 <- arima(google_train$Revenue, order = c(0, 1, 0), 
                seasonal = list(order = c(0, 1, 1), period = 4))
model2 # Amélioration du modèle: AIC a diminué
t_stat(model2) # Coefficient significatif

# Test sur les résidus du modèle 2
ljung_box(model2$residuals)
# On échoue à rejeter l'hypothèse nulle que les résidus sont non corrélés
# Les résidus sont non corrélés
shapiro.test(model2$residuals)
# Les résidus suivent une loi de bruit blanc gaussien avec un risque de 5% 
# de se tromper

# Modèle 3 : ARIMA(2,0,0)(0,1,1)_4 donné par la fonction auto.arima()
model3 <- auto.arima(google_train, stepwise = FALSE, approximation = FALSE)
model3
t_stat(model3)
# Les p-valeurs de tous les coefficients sont infèrieur à 0.05
# donc tous les coefficients sont significatifs.

# Tests sur les résidus pour le Modèle 3
ljung_box(model3$residuals) 
# On utilise le test de Ljung-Box car le jeu de données est petit et que le test
# fonctionne mieux dans ce cas.
# Ici, la p-valeur est plus grande que 0.05, donc on ne parvient pas à rejeter 
# l'hypothèse nulle disant que les résidus suivent une loi bruit blanc.
box_pierce(model3$residuals)
# Même conclusion que le test précédent
shapiro.test(model3$residuals)
# La p-valeur est supèrieur à 0.05, donc on accepte l'hypothèse nulle disant 
# que les résidus suivent une loi bruit blanc gaussien.


################# Prévisions des revenus sur la série de test ##################

h <- length(google_test$Revenue)

# On ne fait pas de prévisions avec le modèle 1
# puisqu'il comprenait un coefficient non significatif

# Prévisions avec le modèle 2
pred2 <- predict(model2, h)
pred2.ts <- ts(pred2$pred)

# Calcul de la MSE et MAE pour le modèle 2
MSE2 <- sum((pred2.ts-google_test_ts)^2)/h
MSE2
MAE2 <- sum(abs(pred2.ts-google_test_ts))/h
MAE2

# Prévisions avec le modèle 3
pred3 <- predict(model1, h)
pred3.ts <- ts(pred1$pred)

# Calcul de la MSE et MAE pour le modèle 3
MSE3 <- sum((pred3.ts-google_test_ts)^2)/h
MSE3
MAE3 <- sum(abs(pred3.ts-google_test_ts))/h
MAE3

# Affichage des prévisions (logarithmiques)
ts.plot(google_test_ts, xlab = "Trimestre", 
        ylab = "Millions de Dollars Américains",
        ylim = c(min(pred2.ts), max(pred2.ts)), 
        main = paste("Prévision des", h, 
                     "dernières valeurs de la série log(google_revenue)"))
par(new = TRUE)
ts.plot(pred2.ts, xlab = "", ylab = "", col = 'red', 
        ylim = c(min(pred2.ts), max(pred2.ts)), gpars = list(axes = FALSE))
par(new = TRUE)
ts.plot(pred3.ts, xlab = "", ylab = "", ylim = c(min(pred2.ts), max(pred2.ts)),
        col = "blue", gpars = list(axes = FALSE))

# Retour à la série initiale en utilisant une transformation exponentielle
pred2_exp <- lapply(pred2$pred, exp)
pred3_exp <- lapply(pred3$pred, exp)
google_test_exp <- lapply(google_test, exp)
pred2_exp.ts <- ts(pred2_exp)
pred3_exp.ts <- ts(pred3_exp)
google_test_exp_ts <- ts(google_test_exp)

# Affichage des prévisions sur la série initiale (non transformée)
ts.plot(google_test_exp_ts$Revenue, xlab = "Trimestre", 
        ylab = "Millions de Dollars Américains",
        ylim = c(min(pred2_exp.ts[[1]]), max(pred2_exp.ts[[1]])), 
        main = paste("Prévision des", h, "dernières valeurs de la série
                     des revenus de Google"))
par(new = TRUE)
ts.plot(pred2_exp.ts[[1]], xlab = "", ylab = "", col = 'red', 
        ylim = c(min(pred2_exp.ts[[1]]), max(pred2_exp.ts[[1]])), 
        gpars = list(axes = FALSE))
par(new = TRUE)
ts.plot(pred3_exp.ts[[1]], xlab = "", ylab = "", 
        ylim = c(min(pred2_exp.ts[[1]]), max(pred2_exp.ts[[1]])),
        col = "blue", gpars = list(axes = FALSE))
