let formContact = document.getElementById('formContact');
    formContact.addEventListener("submit", function(e){
        let nomRegExp = new RegExp('^[a-zA-Z]+[a-zA-Z]+$', 'g');
        let inputNom = document.getElementById('nom');

        let testNom = nomRegExp.test(inputNom.value);
        let errorNom = document.getElementById("errorNom");

    
        if(testNom) {
            errorNom.innerHTML = 'Nom Valide';
            errorNom.style.color ='green';
            e.preventDefault();
        }
        else if(inputNom.value.trim() == ""){
            errorNom.innerHTML = " Le champs nom est requis";
            errorNom.style.color ='red';
            e.preventDefault();
        }
        else{
            errorNom.innerHTML = ' Nom invalide';
            errorNom.style.color ='red';
            e.preventDefault();
        }

        let prenomRegExp = new RegExp('^[a-zA-Z]+[a-zA-Z]+$', 'g');
        let inputPrenom = document.getElementById('prenom');
        let testPrenom = prenomRegExp.test(inputPrenom.value);
        let errorPrenom= document.getElementById("errorPrenom");

    
        if(testPrenom) {
            errorPrenom.innerHTML = 'Prenom Valide';
            errorPrenom.style.color ='green';
            e.preventDefault();
        }
        else if(inputPrenom.value.trim() == ""){
            errorPrenom.innerHTML = " Le champs Prenom est requis";
            errorPrenom.style.color ='red';
            e.preventDefault();
        }
        else{
            errorPrenom.innerHTML = ' Prenom invalide';
            errorPrenom.style.color ='red';
            e.preventDefault();
        }



        let emailRegExp = new RegExp('^[a-zA-Z0-9.-_]+[@]{1}[a-zA-Z0-9.-_]+[.]{1}[a-z]{2,10}$', 'g');
        let inputEmail = document.getElementById('email');
        let testEmail = emailRegExp.test(inputEmail.value);
        let errorEmail = document.getElementById("errorEmail");

    
        if(testEmail) {
            errorEmail.innerHTML = 'Adresse email Valide';
            errorEmail.style.color ='green';
            e.preventDefault();
        }
        else if(inputEmail.value.trim() == ""){
            errorEmail.innerHTML = " Le champs email est requis";
            errorEmail.style.color ='red';
            e.preventDefault();
        }
        else{
            errorEmail.innerHTML = 'Adresse email non Valide';
            errorEmail.style.color ='red';
            e.preventDefault();
        }
    });