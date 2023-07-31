<?php 
    if(isset($_POST["mailforminscr"])){
        $_SESSION['inscription_email'] = $_POST["email"];
        $_SESSION['inscription_mdp'] = $_POST["mdp"];
    }

    if(isset($_POST["mailformcon"])){
        $_SESSION['connexion_email'] = $_POST["email"];
        $_SESSION['connexion_mdp'] = $_POST["mdp"];
    }
    
    $_SESSION['categories'] = array(
        "MPSI" => array(
            "mathematiques" => array(
                "img" => "MPSI-MP2I Maths.jpg",
                "titre" => "Mathématiques MPSI/MP2I - Tout-en-un",
                "auteurs" => "Erik Thoms, Stevan Bellec, Geoffrey Boutard",
                "infos" => "Juin 2021 - 992 pages | ISBN : 978-2-311-40872-0",
                "description" => "Conforme à la nouvelle réforme 2021. Un livre de mathématiques complet et efficace pour faire la différence en prépas MPSI et aux concours.",
                "stock" => 10,
                "prix" => 46.90
            ),
            "physique" => array(
                "img" => "MPSI Physique chimie.jpg",
                "titre" => "Physique-Chimie MPSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Septembre 2021 - 1056 pages | ISBN : 978-2-311-40878-2",
                "description" => "Conforme à la nouvelle réforme 2021. Un livre de physique complet et efficace pour faire la différence en prépas MPSI et aux concours.",
                "stock" => 10,
                "prix" => 49.00
            ),
            "informatique" => array(
                "img" => "MPSI-MP option info.jpg",
                "titre" => "Option informatique MPSI/MP/MP* - Tout-en-un",
                "auteurs" => "Roger Mansuy, Nathaniel Carré",
                "infos" => "Janvier 2019 - 400 pages | ISBN : 978-2-311-40683-2",
                "description" => "Assurez votre réussite avec le seul livre sur le marché en Option informatique",
                "stock" => 10,
                "prix" => 29.90
            ),
            "SI" => array(
                "img" => "MPSI-PCSI SI.jpg",
                "titre" => "Sciences industrielles de l'ingénieur MPSI-PCSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Juin 2019 - 640 pages | ISBN : 978-2-311-40676-4",
                "description" => "Un livre complet et efficace pour assurer sa réussite en MPSI et PCSI.",
                "stock" => 10,
                "prix" => 39.90
            ),
            "francais" => array(
                "img" => "L_enfance.jpg",
                "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                "stock" => 10,
                "prix" => 17.90
            ),
            "anglais" => array(
                "img" => "Anglais.jpg",
                "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                "stock" => 10,
                "prix" => 22.90
            )
        ),

        "PTSI" => array(
            "physique" => array(
                "img" => "PTSI physique chimie.jpg",
                "titre" => "Physique-Chimie PTSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Juillet 2019 - 1152 pages | ISBN : 978-2-311-40687-0",
                "description" => "J'assure ma réussite en Prépas avec la collection Vuibert Prépas !",
                "stock" => 10,
                "prix" => 45.90
            ),
            "mathematiques" => array(
                "img" => "PTSI Maths.jpg",
                "titre" => "Mathématiques PTSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Juillet 2019 - 912 pages | ISBN : 978-2-311-40678-8",
                "description" => "Un livre de mathématiques complet et efficace pour assurer sa réussite en PTSI !",
                "stock" => 10,
                "prix" => 47.90
            ),
            "SI" => array(
                "img" => "PTSI SI.jpg",
                "titre" => "Sciences industrielles de l'ingénieur PTSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Juillet 2019 - 704 pages | ISBN : 978-2-311-40631-3",
                "description" => "Toutes les sciences de l'ingénieur dans un livre complet et efficace pour assurer sa réussite en prépa !",
                "stock" => 10,
                "prix" => 45.90
            ),
            "francais" => array(
                "img" => "L_enfance.jpg",
                "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                "stock" => 10,
                "prix" => 17.90
            ),
            "anglais" => array(
                "img" => "Anglais.jpg",
                "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                "stock" => 10,
                "prix" => 22.90
            )
        ),
        "PCSI" => array(
            "physique" => array(
                "img" => "PCSI Physique.jpg",
                "titre" => "Physique PCSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Août 2021 - 1008 pages | ISBN : 978-2-311-40876-8",
                "description" => "Conforme à la nouvelle réforme 2021. Un livre de physique complet et efficace pour faire la différence en prépas PCSI et aux concours.",
                "stock" => 10,
                "prix" => 45.90
            ),
            "chimie" => array(
                "img" => "PCSI Chimie.jpg",
                "titre" => "Chimie PCSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Juin 2021 - 840 pages | ISBN : 978-2-311-40679-5",
                "description" => "Un livre de chimie complet et efficace pour faire la différence en prépas PCSI.",
                "stock" => 10,
                "prix" => 45.90
            ),
            "mathematiques" => array(
                "img" => "PCSI Maths.jpg",
                "titre" => "Mathématiques PCSI - Tout-en-un",
                "auteurs" => "Olivier Coulaud",
                "infos" => "Juin 2019 - 912 pages | ISBN : 978-2-311-40677-1",
                "description" => "Assurez votre réussite en prépas avec ce livre de Mathématiques PCSI au cœur des attentes et des besoins des élèves.",
                "stock" => 10,
                "prix" => 45.90
            ),
            "SI" => array(
                "img" => "MPSI-PCSI SI.jpg",
                "titre" => "Sciences industrielles de l'ingénieur MPSI-PCSI - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => "Juin 2019 - 640 pages | ISBN : 978-2-311-40676-4",
                "description" => "Un livre complet et efficace pour assurer sa réussite en MPSI et PCSI.",
                "stock" => 10,
                "prix" => 39.90
            ),
            "francais" => array(
                "img" => "L_enfance.jpg",
                "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                "stock" => 10,
                "prix" => 17.90
            ),
            "anglais" => array(
                "img" => "Anglais.jpg",
                "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                "stock" => 10,
                "prix" => 22.90
            )
        ),
        "BCPST1" => array(
            "geologie" => array(
                "img" => "BCPST1 biologie geologie.jpg",
                "titre" => "Biologie-Géologie BCPST -1re année - Tout-en-un",
                "auteurs" => "Collectif",
                "infos" => "Août 2017 - 992 pages | ISBN : 978-2-311-40401-2",
                "description" => "Un tout-en-un pour réussir !",
                "stock" => 10,
                "prix" => 49.90
            ),
            "mathematiques" => array(
                "img" => "BCPST1 maths info.jpg",
                "titre" => "Maths BCPST 1re année - Tout-en-un",
                "auteurs" => "Olivier Coulaud, Jérôme Verliat",
                "infos" => "Juillet 2017 - 752 pages | ISBN : 978-2-311-40407-4",
                "description" => "Vuibert Prépas, des ouvrages pour faire la différence !",
                "stock" => 10,
                "prix" => 39.90
            ),
            "geographie" => array(
                "img" => "BCPST geographie.jpg",
                "titre" => "Mémento Géographie BCPST- CPGE littéraires Sujets types – Commentaires de cartes topographiques – Études de documents",
                "auteurs" => "Collectif",
                "infos" => "Juillet 2018 - 304 pages | ISBN : 978-2-311-40632-0",
                "description" => "Le seul ouvrage de géographie tout en couleurs à destination des filières BCPST - TB - CPGE littéraires et des préparationnaires au CAPES et à l'Agrégation.",
                "stock" => 10,
                "prix" => 30.00
            ),
            "biologie" => array(
                "img" => "BCPST1et2 Bilogie.jpg",
                "titre" => "Mémento de Biologie BCPST 1re et 2e années - Notions-clés - Schémas de synthèse - Lexique - Conforme à la réforme 2021",
                "auteurs" => "Marc Derumaux, Alexis Redondo, Vincent Crespel",
                "infos" => "Juillet 2021 - 256 pages | ISBN : 978-2-311-40859-1",
                "description" => "Conforme au nouveau programme BCPST, cette nouvelle édition du Mémento de Biologie propose l'intégralité des grands thèmes à connaître en Biologie pour les deux années à travers plus de 100 fiches de cours et schémas de synthèse inédits.",
                "stock" => 10,
                "prix" => 24.90
            ),
            "francais" => array(
                "img" => "L_enfance.jpg",
                "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                "stock" => 10,
                "prix" => 17.90
            ),
            "anglais" => array(
                "img" => "Anglais.jpg",
                "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                "stock" => 10,
                "prix" => 22.90
            )
            ),
        
        "MP" => array(
            "matemathiques" => array(
                "img" => "MP Maths.jpg",
                "titre" => "Mathématiques MP/MP* - Tout-en-un",
                "auteurs" => "Xavier Oudot, Charles Cochet",
                "infos" => "Juillet 2020 - 800 pages | ISBN : 978-2-311-40743-3",
                "description" => "Un livre de mathématiques complet et efficace pour faire la différence en prépas MP/MP* et aux concours.",
                "prix" => 47.90,
                "stock"=> 10
            ),

            "physique" => array(
                "img" => "MP Physique.jpg",
                "titre" => "Physique MP/MP* - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => " Juillet 2020 - 720 pages | ISBN : 978-2-311-40724-2",
                "description" => "Un livre de physique complet et efficace pour faire la différence en prépas MP/MP* et aux concours.",
                "prix" => 45.90,
                "stock"=> 17
            ),

            "chimie" => array(
                "img" => "MP-PSI Chimie.jpg",
                "titre" => "Chimie MP/MP* PSI/PSI* - Tout-en-un",
                "auteurs" => "Yann Lozier, Frédéric Bruneau, Marc Cavelier",
                "infos" => "Juillet 2020 - 320 pages | ISBN : 978-2-311-40742-6",
                "description" => "Un livre de chimie complet et efficace pour faire la différence en prépas MP/MP* et PSI/PSI* et aux concours.",
                "prix" => 30,
                "stock"=> 19
            ),

            "sii" => array(
                "img" => "MP-PSI-PT SI.jpg",
                "titre" => "Sciences industrielles de l'ingénieur MP/MP* PSI/PSI* PT/PT* - Tout-en-un",
                "auteurs" => "Marc Derumaux, Alexis Redondo, Vincent Crespel",
                "infos" => "Juillet 2020 - 544 pages | ISBN : 978-2-311-40741-9",
                "description" => "Toutes les sciences industrielles dans un livre complet et efficace pour faire la différence en prépas MP/MP* - PSI/PSI*- PT/PT* et aux concours.",
                "prix" => 29.90,
                "stock"=> 8
            ),

            "optionInfo" => array(
                "img" => "MPSI-MP option info.jpg",
                "titre" => "Option informatique MPSI/MP/MP* - Tout-en-un",
                "auteurs" => "Roger Mansuy, Nathaniel Carré",
                "infos" => "Janvier 2019 - 400 pages | ISBN : 978-2-311-40683-2",
                "description" => "Assurez votre réussite avec le seul livre sur le marché en Option informatique",
                "prix" => 29.90,
                "stock"=> 8
            ),

            "francais philosophie" => array(
                "img" => "L_enfance.jpg",
                "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                "prix" => 17.90,
                "stock"=> 4
            ),

            "anglais" => array(
                "img" => "Anglais.jpg",
                "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                "prix" => 22.90,
                "stock"=> 7
            )
        ),
        
        "PT" => array(
            "physiqueChimie" => array(
                "img" => "PT physique chimie.jpg",
                "titre" => "Physique-Chimie PT/PT* - Tout-en-un",
                "auteurs" => "Auteurs multiples",
                "infos" => " Juillet 2020 - 880 pages | ISBN : 978-2-311-40725-9",
                "description" => "Un livre de physique-chimie complet et efficace pour faire la différence en prépas PT/PT* et aux concours.",
                "prix" => 46.90,
                "stock"=> 17
            ),

            "mathematique" => array(
                "img" => "PC-PSI-PT maths.jpg",
                "titre" => "Maths PC/PC* PSI/PSI* PT/PT* -Tout-en-un",
                "auteurs" => "Vincent Queffelec",
                "infos" => " Juillet 2014 - 744 pages | ISBN : 978-2-311-40027-4",
                "description" => "Assurez votre réussite en prépas avec ce livre de PC/PC* au cœur des attentes et des besoins des élèves.",
                "prix" => 48.90,
                "stock"=> 20
            ),

            "sii" => array(
                "img" => "MP-PSI-PT SI.jpg",
                "titre" => "Sciences industrielles de l'ingénieur MP/MP* PSI/PSI* PT/PT* - Tout-en-un",
                "auteurs" => "Marc Derumaux, Alexis Redondo, Vincent Crespel",
                "infos" => " Juillet 2020 - 544 pages | ISBN : 978-2-311-40741-9",
                "description" => "Toutes les sciences industrielles dans un livre complet et efficace pour faire la différence en prépas MP/MP* - PSI/PSI*- PT/PT* et aux concours.",
                "prix" => 29.90,
                "stock"=> 10
            ),

            "francais philosophie" => array(
                "img" => "L_enfance.jpg",
                "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                "prix" => 17.90,
                "stock"=> 4
            ),

            "anglais" => array(
                "img" => "Anglais.jpg",
                "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                "prix" => 22.90,
                "stock"=> 7
                
            )
            ),

            "PC" => array(
                "physique" => array(
                    "img" => "PC physique.jpg",
                    "titre" => "Physique PC/PC* - Tout-en-un",
                    "auteurs" => "Mehdi Nehmé, Pierre Jamonneau, Raphaël Proux",
                    "infos" => "Juillet 2020 - 1152 pages | ISBN : 978-2-311-40718-1",
                    "description" => "Toute la physique dans un livre complet et efficace pour faire la différence en prépas PC/PC* et aux concours.",
                    "prix" => 49,
                    "stock"=> 4
                    
                ),

                "chimie" => array(
                    "img" => "PC chimie.jpg",
                    "titre" => "Chimie PC/PC* - Tout-en-un",
                    "auteurs" => "Hélène Arcostanzo, Dominique Loeuillet, Florence Edard",
                    "infos" => "Juillet 2020 - 944 pages | ISBN : 978-2-311-40739-6",
                    "description" => "Un livre de chimie complet et efficace pour faire la différence en prépas PC/PC* et aux concours.",
                    "prix" => 45.90,
                    "stock"=> 8
                ),

                "mathematique" => array(
                    "img" => "PC-PSI-PT maths.jpg",
                    "titre" => "Maths PC/PC* PSI/PSI* PT/PT* -Tout-en-un",
                    "auteurs" => "Vincent Queffelec",
                    "infos" => " Juillet 2014 - 744 pages | ISBN : 978-2-311-40027-4",
                    "description" => "Assurez votre réussite en prépas avec ce livre de PC/PC* au cœur des attentes et des besoins des élèves.",
                    "prix" => 48.90,
                    "stock"=> 20
                ),
    
                "francais philosophie" => array(
                    "img" => "L_enfance.jpg",
                    "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                    "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                    "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                    "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                    "prix" => 17.90,
                    "stock"=> 4
                ),
    
                "anglais" => array(
                    "img" => "Anglais.jpg",
                    "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                    "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                    "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                    "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                    "prix" => 22.90,
                    "stock"=> 7   
                )
                ),

            "PSI" => array(
                "physique" => array(
                    "img" => "PSI physique.jpg",
                    "titre" => "Physique PSI/PSI* - Tout-en-un",
                    "auteurs" => "Collectif",
                    "infos" => "Juillet 2020 - 944 pages | ISBN : 978-2-311-40723-5",
                    "description" => "Toute la physique dans un livre complet et efficace pour faire la différence en prépas PSI/PSI* et aux concours.",
                    "prix" => 48.90,
                    "stock"=> 12
                ),

                "chimie" => array(
                    "img" => "MP-PSI Chimie.jpg",
                    "titre" => "Chimie MP/MP* PSI/PSI* - Tout-en-un",
                    "auteurs" => "Yann Lozier, Frédéric Bruneau, Marc Cavelier",
                    "infos" => "Juillet 2020 - 320 pages | ISBN : 978-2-311-40742-6",
                    "description" => "Un livre de chimie complet et efficace pour faire la différence en prépas MP/MP* et PSI/PSI* et aux concours.",
                    "prix" => 30,
                    "stock"=> 10
                ),

                "sii" => array(
                    "img" => "MP-PSI-PT SI.jpg",
                    "titre" => "Sciences industrielles de l'ingénieur MP/MP* PSI/PSI* PT/PT* - Tout-en-un",
                    "auteurs" => "Marc Derumaux, Alexis Redondo, Vincent Crespel",
                    "infos" => "Juillet 2020 - 544 pages | ISBN : 978-2-311-40741-9",
                    "description" => "Toutes les sciences industrielles dans un livre complet et efficace pour faire la différence en prépas MP/MP* - PSI/PSI*- PT/PT* et aux concours.",
                    "prix" => 29.90,
                    "stock"=> 10
                ),

                "mathematique" => array(
                    "img" => "PC-PSI-PT maths.jpg",
                    "titre" => "Maths PC/PC* PSI/PSI* PT/PT* -Tout-en-un",
                    "auteurs" => "Vincent Queffelec",
                    "infos" => " Juillet 2014 - 744 pages | ISBN : 978-2-311-40027-4",
                    "description" => "Assurez votre réussite en prépas avec ce livre de PC/PC* au cœur des attentes et des besoins des élèves.",
                    "prix" => 48.90,
                    "stock"=> 20
                ),
    
                "francais philosophie" => array(
                    "img" => "L_enfance.jpg",
                    "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                    "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                    "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                    "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                    "prix" => 17.90,
                    "stock"=> 4
                ),
    
                "anglais" => array(
                    "img" => "Anglais.jpg",
                    "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                    "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                    "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                    "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                    "prix" => 22.90,
                    "stock"=> 7   
                )
            ),

            "BCPST2" => array(
                "biogeo" => array(
                    "img" => "BCPST2 Biologie geologie.jpg",
                    "titre" => "Biologie-Géologie BCPST 2e année - Tout-en-un",
                    "auteurs" => "Collectif",
                    "infos" => "Août 2019 - 896 pages | ISBN : 978-2-311-40570-5",
                    "description" => "Le seul ouvrage regroupant la biologie et la géologie, complet et efficace, pour assurer sa réussite au concours !",
                    "prix" => 54.90,
                    "stock"=> 10
                ),

                "mathematique" => array(
                    "img" => "BCPST2 maths info.jpg",
                    "titre" => "Mathématiques et informatique BCPST 2e année - Tout-en-un",
                    "auteurs" => "Jérôme Verliat, Stella VISIER",
                    "infos" => "Juillet 2018- 560 pages | ISBN : 978-2-311-40571-2",
                    "description" => "Le cours complet et tout l'entraînement indispensable pour réussir sa 2e année de BCPST en mathématiques.",
                    "prix" => 38.90,
                    "stock"=> 10
                ),

                "mementoBio" => array(
                    "img" => "BCPST1et2 Biologie.jpg",
                    "titre" => "Mémento Biologie BCPST 1re et 2e années - Tout-en-un",
                    "auteurs" => "Collectif",
                    "infos" => "Août 2018 - 240 pages |ISBN : 978-2-311-40573-6",
                    "description" => "Tous les grands thèmes de géologie (schémas, roches et régions) à maîtriser pour les deux années de classes préparatoires BCPST, le CAPES et l'Agrégation.",
                    "prix" => 38.90,
                    "stock"=> 10
                ),

                "mementoGeo" => array(
                    "img" => "BCPST geographie.jpg",
                    "titre" => "Mémento Géographie BCPST- CPGE littéraires - CAPES/AGREG",
                    "auteurs" => "Collectif",
                    "infos" => "Juillet 2018 - 304 pages | ISBN : 978-2-311-40632-0",
                    "description" => "Le seul ouvrage de géographie tout en couleurs à destination des filières BCPST - TB - CPGE littéraires et des préparationnaires au CAPES et à l'Agrégation.",
                    "prix" => 24.90,
                    "stock"=> 10
                ),

                "francais philosophie" => array(
                    "img" => "L_enfance.jpg",
                    "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                    "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                    "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                    "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                    "prix" => 17.90,
                    "stock"=> 4
                ),
    
                "anglais" => array(
                    "img" => "Anglais.jpg",
                    "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                    "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                    "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                    "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                    "prix" => 22.90,
                    "stock"=> 7   
                )
                ),
            "tendances" => array(
                "francais philosophie" => array(
                    "img" => "L_enfance.jpg",
                    "titre" => "L'enfance - Épreuve de français-philosophie - Prépas scientifiques - Concours 2021-2022 - Tout-en-un",
                    "auteurs" => "Glen Grainger, Benoît Charuau, Catherine Feré",
                    "infos" => "Mai 2021 - 320 pages | ISBN : 978-2-311-40858-4",
                    "description" => "Une préparation complète à l'épreuve littéraire des concours 2021/ 2022 des prépas scientifiques sur le thème de l'enfance.",
                    "prix" => 17.90,
                    "stock"=> 4
                ),
    
                "anglais" => array(
                    "img" => "Anglais.jpg",
                    "titre" => "Anglais - Prépas scientifiques - Tout-en-un",
                    "auteurs" => "Antoine Devin, Sandrine Merle, Franck Nebeker",
                    "infos" => "Juin 2021 - 336 pages | ISBN : 978-2-311-40934-5",
                    "description" => "Conforme à la nouvelle réforme 2021. Le tout-en-un indispensable en Anglais pour réussir sa prépa scientifique MPSI, PCSI, PTSI, MP2I, BCPST, MP, PC, PSI, PT, TSI et ATS et réussir les concours (écrits et oraux).",
                    "prix" => 22.90,
                    "stock"=> 7   
                ),

                "mathematiques" => array(
                    "img" => "MPSI-MP2I Maths.jpg",
                    "titre" => "Mathématiques MPSI/MP2I - Tout-en-un",
                    "auteurs" => "Erik Thoms, Stevan Bellec, Geoffrey Boutard",
                    "infos" => "Juin 2021 - 992 pages | ISBN : 978-2-311-40872-0",
                    "description" => "Conforme à la nouvelle réforme 2021. Un livre de mathématiques complet et efficace pour faire la différence en prépas MPSI et aux concours.",
                    "stock" => 10,
                    "prix" => 46.90
                )
            )

        )
    


    

    
    
?>