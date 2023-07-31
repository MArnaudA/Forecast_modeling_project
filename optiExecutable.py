from tkinter import *
from tkinter import font
import time

import pulp as p

D = {  # Fixe
    "1": [50, 60, 80],
    "2": [50, 50, 80],
    "3": [30, 50, 80],
    "4": [30, 40, 70]
}

E = {  # Fixe
    "1": [80, 100, 150],
    "2": [120, 150, 140],
    "3": [120, 100, 150],
    "4": [80, 120, 130]
}

T = {  # Fixe
    "1": [0, 2, 1],
    "2": [1, 2, 0],
    "3": [2, 0, 1],
    "4": [0, 1, 0]
}

V = {
    "1": 7000,
    "2": 2000,
    "3": 8000,
    "4": 2000
}

SI = {
    "1": 2000,
    "2": 0,
    "3": 2000,
    "4": 1000
}

SS = {
    "1": 1000,
    "2": 1000,
    "3": 2000,
    "4": 1000
}


class Application(Tk):

    def __init__(self, *args, **kwargs):
        Tk.__init__(self, *args, **kwargs)

        self.title('Optimisation des coûts')
        self.geometry("1200x800")
        self.title_font = font.Font(family='Helvetica', size=40, weight="bold", slant="italic")
        # self.minsize(1000,300) : a voir sur un écran complet, si la page est trop petite, la mise en page est moche

        container = Frame(self)
        container.pack(side="top", fill="both", expand=True)
        container.grid_rowconfigure(0, weight=1)
        container.grid_columnconfigure(0, weight=1)

        self.frames = {}
        for F in (PageConnexion, Categorie1, Categorie2, Categorie3, Categorie4, Resultat):
            page_name = F.__name__
            frame = F(parent=container, controller=self)
            self.frames[page_name] = frame

            frame.grid(row=0, column=0, sticky="nsew")

        self.show_frame("PageConnexion")

    def show_frame(self, page_name):
        frame = self.frames[page_name]
        frame.tkraise()

class PageConnexion(Frame):

    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Page de connexion", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)

        passwordLabel = Label(self, text="Mot de passe")
        passwordEntry = Entry(self, show='*')
        passwordLabel.pack()
        passwordEntry.pack()

        def valid():
            test1 = (passwordEntry.get() == "ProjetGM22")
            if test1:
                print("mot de passe valide !")
                controller.show_frame("Categorie1")
            else:
                wrong_values2()

        def wrong_values2():
            top = Tk()
            top.config(bg='#ffdddd')
            top.geometry("350x100")
            top.title("Erreur")
            Label(top, text="Mot de passe incorrect", font=('Courrier', 17), bg='#ffdddd').place(x=45, y=30)

        bouton_connexion = Button(self, text="Se connecter", command=valid)
        bouton_connexion.pack()


def wrong_values():
          top = Tk()
          top.config(bg='#ffdddd')
          top.geometry("480x100")
          top.title("Erreur")
          Label(top, text="Veuillez entrer des valeurs correctes", font=('Courrier', 16), bg='#ffdddd').place(x=45, y=30)


class Categorie1(Frame):

    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Produit 1", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)

        frame_q1 = Frame(self, bg='white', bd=1)
        label_q1 = Label(frame_q1, text = "quelle est la demande (en tonnes) du produit 1 ?", font=("Courrier", 15),
                         bg='white')
        label_q1.pack()
        entry_r1 = Entry(frame_q1, font=("Courrier", 15), bg='white')
        entry_r1.pack()
        frame_q1.pack(expand=YES)

        frame_q2 = Frame(self, bg='white', bd=1)
        label_q2 = Label(frame_q2, text="quel est le stock initial (en tonnes) disponible cette semaine ? (obligatoire)",
                         font=("Courrier", 15), bg='white')
        label_q2.pack()
        entry_r2 = Entry(frame_q2, font=("Courrier", 15), bg='white')
        entry_r2.pack()
        frame_q2.pack(expand=YES)

        frame_q3 = Frame(self, bg='white', bd=1)
        label_q3 = Label(frame_q3,
                         text="quel est le stock de sécurité (en tonnes) dont il faut disposer en fin de semaine ? ",
                         font=("Courrier", 15), bg='white')
        label_q3.pack()
        entry_r3 = Entry(frame_q3, font=("Courrier", 15), bg='white')
        entry_r3.pack()
        frame_q3.pack(expand=YES)


        def valid():
            test1, test2, test3 = True, False, True
            if len(entry_r1.get()) != 0:
                test1 = (entry_r1.get()).isnumeric()
            test2 = (entry_r2.get()).isnumeric()
            if len(entry_r3.get()) != 0:
                test3 = (entry_r3.get()).isnumeric()
            if test1 & test2 & test3:
                controller.show_frame("Categorie2")
            else:
                wrong_values()

        #Variables globales en attendant de trouver pourquoi Categorie1.entry_r1 n'est pas accessible dans le reste du programme
        global cat1_r1
        global cat1_r2
        global cat1_r3
        cat1_r1 = entry_r1.get()
        cat1_r2 = entry_r2.get()
        cat1_r3 = entry_r3.get()

        button = Button(self, text="Suivant", command=valid)
        button.pack()


class Categorie2(Frame):

    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Produit 2", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)

        frame_q1 = Frame(self, bg='white', bd=1)
        label_q1 = Label(frame_q1, text="Quelle est la demande (en tonnes) du produit 2 ? ", font=("Courrier", 15),
                         bg='white')
        label_q1.pack()
        entry_r1 = Entry(frame_q1, font=("Courrier", 15), bg='white')
        entry_r1.pack()
        frame_q1.pack(expand=YES)

        frame_q2 = Frame(self, bg='white', bd=1)
        label_q2 = Label(frame_q2, text="Quel est le stock initial (en tonnes) disponible cette semaine ? (obligatoire)",
                         font=("Courrier", 15), bg='white')
        label_q2.pack()
        entry_r2 = Entry(frame_q2, font=("Courrier", 15), bg='white')
        entry_r2.pack()
        frame_q2.pack(expand=YES)

        frame_q3 = Frame(self, bg='white', bd=1)
        label_q3 = Label(frame_q3,
                         text="Quel est le stock de sécurité (en tonnes) dont il faut disposer en fin de semaine ? ",
                         font=("Courrier", 15), bg='white')
        label_q3.pack()
        entry_r3 = Entry(frame_q3, font=("Courrier", 15), bg='white')
        entry_r3.pack()
        frame_q3.pack(expand=YES)

        bouton_retour = Button(self, text="Retour", command=lambda: controller.show_frame("Categorie1"))
        bouton_retour.pack()

        def valid():
            test1, test3 = True, True
            if len(entry_r1.get()) != 0:
                test1 = (entry_r1.get()).isnumeric()
            test2 = (entry_r2.get()).isnumeric()
            if len(entry_r3.get()) != 0:
                test3 = (entry_r3.get()).isnumeric()
            if test1 & test2 & test3:
                controller.show_frame("Categorie3")
            else:
                wrong_values()
              
        global cat2_r1
        global cat2_r2
        global cat2_r3
        cat2_r1 = entry_r1.get()
        cat2_r2 = entry_r2.get()
        cat2_r3 = entry_r3.get()    
              
        button = Button(self, text="Suivant", command=valid)
        button.pack()


class Categorie3(Frame):

    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Produit 3", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)

        frame_q1 = Frame(self, bg='white', bd=1)
        label_q1 = Label(frame_q1, text="Quelle est la demande (en tonnes) du produit 3 ?", font=("Courrier", 15),
                         bg='white')
        label_q1.pack()
        entry_r1 = Entry(frame_q1, font=("Courrier", 15), bg='white')
        entry_r1.pack()
        frame_q1.pack(expand=YES)

        frame_q2 = Frame(self, bg='white', bd=1)
        label_q2 = Label(frame_q2, text="Quel est le stock initial (en tonnes) disponible cette semaine ? (obligatoire)",
                         font=("Courrier", 15), bg='white')
        label_q2.pack()
        entry_r2 = Entry(frame_q2, font=("Courrier", 15), bg='white')
        entry_r2.pack()
        frame_q2.pack(expand=YES)

        frame_q3 = Frame(self, bg='white', bd=1)
        label_q3 = Label(frame_q3,
                         text="Quel est le stock de sécurité (en tonnes) dont il faut disposer en fin de semaine ? ",
                         font=("Courrier", 15), bg='white')
        label_q3.pack()
        entry_r3 = Entry(frame_q3, font=("Courrier", 15), bg='white')
        entry_r3.pack()
        frame_q3.pack(expand=YES)

        bouton_retour = Button(self, text="Retour", command=lambda: controller.show_frame("Categorie2"))
        bouton_retour.pack()


        def valid():
            test1, test3 = True, True
            if len(entry_r1.get()) != 0:
                test1 = (entry_r1.get()).isnumeric()
            test2 = (entry_r2.get()).isnumeric()
            if len(entry_r3.get()) != 0:
                test3 = (entry_r3.get()).isnumeric()
            if test1 & test2 & test3:
                controller.show_frame("Categorie4")
            else:
                wrong_values()
                

        global cat3_r1
        global cat3_r2
        global cat3_r3
        cat3_r1 = entry_r1.get()
        cat3_r2 = entry_r2.get()
        cat3_r3 = entry_r3.get()
      
        button = Button(self, text="Suivant", command=valid)
        button.pack()


class Categorie4(Frame):

    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Produit 4", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)

        frame_q1 = Frame(self, bg='white', bd=1)
        label_q1 = Label(frame_q1, text="Quelle est la demande (en tonnes) du produit 4 ? ", font=("Courrier", 15),
                         bg='white')
        label_q1.pack()
        entry_r1 = Entry(frame_q1, font=("Courrier", 15), bg='white')
        entry_r1.pack()
        frame_q1.pack(expand=YES)

        frame_q2 = Frame(self, bg='white', bd=1)
        label_q2 = Label(frame_q2, text="Quel est le stock initial (en tonnes) disponible cette semaine ? (obligatoire)",
                         font=("Courrier", 15), bg='white')
        label_q2.pack()
        entry_r2 = Entry(frame_q2, font=("Courrier", 15), bg='white')
        entry_r2.pack()
        frame_q2.pack(expand=YES)

        frame_q3 = Frame(self, bg='white', bd=1)
        label_q3 = Label(frame_q3,
                         text="Quel est le stock de sécurité (en tonnes) dont il faut disposer en fin de semaine ? ",
                         font=("Courrier", 15), bg='white')
        label_q3.pack()
        entry_r3 = Entry(frame_q3, font=("Courrier", 15), bg='white')
        entry_r3.pack()
        frame_q3.pack(expand=YES)

        bouton_retour = Button(self, text="Retour", command=lambda: controller.show_frame("Categorie3"))
        bouton_retour.pack()

        def valid():
            test1, test3 = True, True
            if len(entry_r1.get()) != 0:
                test1 = (entry_r1.get()).isnumeric()
            test2 = (entry_r2.get()).isnumeric()
            if len(entry_r3.get()) != 0:
                test3 = (entry_r3.get()).isnumeric()
            if test1 & test2 & test3:
                controller.show_frame("Resultat")
            else:
                wrong_values()


        global cat4_r1
        global cat4_r2
        global cat4_r3
        cat4_r1 = entry_r1.get()
        cat4_r2 = entry_r2.get()
        cat4_r3 = entry_r3.get()
      
        button = Button(self, text="Calculer résultat optimal", command=valid)
        button.pack()


class Resultat(Frame):

    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Résultats", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)

        demande1 = cat1_r1
        if len(demande1) != 0:
            V["1"] = int(demande1)

        #Test nécessaire pour le programme, mais inutile en pratique puisque l'utilisateur sera obligé de rentrer une valeur pour cat1_r2
        if cat1_r2.isnumeric():
          print("cat1_r2 =", cat1_r2)
          SI["1"] = cat1_r2
        else:
          print("SI['1'] =", SI["1"])
        
        stockSecurite1 = cat1_r3
        if len(stockSecurite1) != 0:
            SS["1"] = int(stockSecurite1)

        demande2 = cat2_r1
        if len(demande2) != 0:
            V["2"] = int(demande2)

        if cat2_r2.isnumeric():
          print("cat2_r2 =", cat2_r2)
          SI["2"] = cat2_r2
        else:
          print("SI['2'] =", SI["2"])

        stockSecurite2 = cat2_r3
        if len(stockSecurite2) != 0:
            SS["2"] = int(stockSecurite2)

        demande3 = cat3_r1
        if len(demande3) != 0:
            V["3"] = int(demande3)

        if cat3_r2.isnumeric():
          print("cat3_r2 =", cat3_r2)
          SI["3"] = cat3_r2
        else:
          print("SI['3'] =", SI["3"])

        stockSecurite3 = cat3_r3
        if len(stockSecurite3) != 0:
            SS["3"] = int(stockSecurite3)

        demande4 = cat4_r1
        if len(demande4) != 0:
            V["4"] = int(demande4)

        if cat4_r2.isnumeric():
          print("cat4_r2 =", cat4_r2)
          SI["4"] = cat4_r2
        else:
          print("SI['4'] =", SI["4"])

        stockSecurite4 = cat4_r3
        if len(stockSecurite4) != 0:
            SS["4"] = int(stockSecurite4)

      
        optiCoutConso = p.LpProblem("optiCoutConso")
        
        X11 = p.LpVariable("X11", lowBound = 0)  
        X12 = p.LpVariable("X12", lowBound = 0)  
        X13 = p.LpVariable("X13", lowBound = 0)  
        X14 = p.LpVariable("X14", lowBound = 0)  
        X21 = p.LpVariable("X21", lowBound = 0)  
        X22 = p.LpVariable("X22", lowBound = 0)  
        X23 = p.LpVariable("X23", lowBound = 0)  
        X24 = p.LpVariable("X24", lowBound = 0)  
        X31 = p.LpVariable("X31", lowBound = 0)  
        X32 = p.LpVariable("X32", lowBound = 0)  
        X33 = p.LpVariable("X33", lowBound = 0)  
        X34 = p.LpVariable("X34", lowBound = 0)

        

        fonctionObjectif = (0.1 * E["1"][0] + T["1"][0]) * D["1"][0] * X11 + (0.1 * E["1"][1] + T["1"][1]) * D["1"][1] * X21 + (0.1 * E["1"][2] + T["1"][2]) * D["1"][2] * X31 + (0.1 * E["2"][0] + T["2"][0]) * D["2"][0] * X12 + (0.1 * E["2"][1] + T["2"][1]) * D["2"][1] * X22 + (0.1 * E["2"][2] + T["2"][2]) * D["2"][2] * X32 + (0.1 * E["3"][0] + T["3"][0]) * D["3"][0] * X13 + (0.1 * E["3"][1] + T["3"][1]) * D["3"][1] * X23 + (0.1 * E["3"][2] + T["3"][2]) * D["3"][2] * X33 + (0.1 * E["4"][0] + T["4"][0]) * D["4"][0] * X14 + (0.1 * E["4"][1] + T["4"][1]) * D["4"][1] * X24 + (0.1 * E["4"][2] + T["4"][2]) * D["4"][2] * X34
      
        optiCoutConso += fonctionObjectif

        ctProd1 = D["1"][0] * X11 + D["1"][1] * X21 + D["1"][2] * X31 >= V["1"] + SS["1"] - int(SI["1"])
        optiCoutConso += ctProd1
        ctProd2 = D["2"][0] * X12 + D["2"][1] * X22 + D["2"][2] * X32 >= V["2"] + SS["2"] - SI["2"]
        optiCoutConso += ctProd2
        ctProd3 = D["3"][0] * X13 + D["3"][1] * X23 + D["3"][2] * X33 >= V["3"] + int(SS["3"]) - SI["3"]
        optiCoutConso += ctProd3
        ctProd4 = D["4"][0] * X14 + D["4"][1] * X24 + D["4"][2] * X34 >= V["4"] + int(SS["4"]) - SI["4"]
        optiCoutConso += ctProd4

        ctCapacite1 = X11 + X12 + X13 + X14 <= 144
        optiCoutConso += ctCapacite1
        ctCapacite2 = X21 + X22 + X23 + X24 <= 144
        optiCoutConso += ctCapacite2
        ctCapacite3 = X31 + X32 + X33 + X34 <= 144
        optiCoutConso += ctCapacite3

        res = optiCoutConso.solve()


        f1 = Frame(self, bg = "white", bd = 1)
        l0 = Label(f1, text="Pour optimiser vos coûts, vous devrez faire fonctionner vos broyeurs de la façon suivante:\n", font=("Courrier", 15), bg='white')
        l0.pack()
        
        l1 = Label(f1, text= "* Broyeur 1:", font=("Courrier", 15), bg='white')
        l1.pack()
        l2 = Label(f1, text= f"* {round(X11.value(),1)} heures pour le produit 1\n* {X12.value()} heures pour le produit 2\n* {round(X13.value(),1)} heures pour le produit 3\n* {round(X14.value(),1)} heures pour le produit 4.\n\n", font=("Courrier", 15), bg='white')
        l2.pack()

        l3 = Label(f1, text= "* Broyeur 2:", font=("Courrier", 15), bg='white')
        l3.pack()
        l4 = Label(f1, text= f"* {round(X21.value(),1)} heures pour le produit 1\n* {round(X22.value(),1)} heures pour le produit 2\n* {round(X23.value(),1)} heures pour le produit 3\n* {round(X24.value(),1)} heures pour le produit 4.\n\n", font=("Courrier", 15), bg='white')
        l4.pack()

        l5 = Label(f1, text= "* Broyeur 3:", font=("Courrier", 15), bg='white')
        l5.pack()
        l6 = Label(f1, text= f"* {round(X31.value(),1)} heures pour le produit 1\n* {round(X32.value(),1)} heures pour le produit 2\n* {round(X33.value(),1)} heures pour le produit 3\n* {round(X34.value(),1)} heures pour le produit 4.", font=("Courrier", 15), bg='white')
        l6.pack()
        f1.pack(expand=YES)
        
        """bouton_retour = Button(self, text="Voir l'analyse de sensibilité", command = lambda: controller.show_frame("AnalyseSensibilite"))
        bouton_retour.pack(expand=YES)"""
        
"""class AnalyseSensibilite(Frame):
    
    def __init__(self, parent, controller):
        Frame.__init__(self, parent)
        self.controller = controller
        label = Label(self, text="Analyse sensibilité", font=controller.title_font)
        label.pack(side="top", fill="x", pady=10)
        
        bouton_retour = Button(self, text="Retourner aux résultats", command = lambda: controller.show_frame("Resultat"))
        bouton_retour.pack(expand=YES)"""

if __name__ == "__main__":
    app = Application()
    app.mainloop()