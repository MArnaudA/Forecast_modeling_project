let formInscription = document.getElementById('formInscription');
    formInscription.addEventListener("submit", function(e){
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

    let inputMdp = document.getElementById('mdp');
    let errorMdp = document.getElementById('errorMdp');
    if(inputMdp.value.trim() == ""){
        errorMdp.innerHTML = " Le champs mot de passe est requis";
        errorMdp.style.color ='red';
        e.preventDefault();
    }
    else if(inputMdp.value.length < 3){
        errorMdp.innerHTML = " Le mot de passe doit contenir au moins 3 caractères";
        errorMdp.style.color ='red';
        e.preventDefault();
    }
    else if(!/[A-Z]/.test(inputMdp.value)){
        errorMdp.innerHTML = " Le mot de passe doit contenir au moins 1 majuscule";
        errorMdp.style.color ='red';
        e.preventDefault();
    }
    else if(!/[0-9]/.test(inputMdp.value)){
        errorMdp.innerHTML = " Le mot de passe doit contenir au moins 1 chiffre";
        errorMdp.style.color ='red';
        e.preventDefault();
    }
    else{
        errorMdp.innerHTML = " Le mot de passe est Valide";
        errorMdp.style.color ='green';
        e.preventDefault();
    }

    let inputMdpc = document.getElementById('mdpc');
    let errorMdpc = document.getElementById('errorMdpc');

    if(inputMdpc.value.trim() == ""){
        errorMdpc.innerHTML = " Le champs confirmation de mot de passe est requis";
        errorMdpc.style.color ='red';
        e.preventDefault();
    }
    else if(inputMdpc.value.length < 3){
        errorMdpc.innerHTML = " Le mot de passe doit contenir au moins 3 caractères";
        errorMdpc.style.color ='red';
        e.preventDefault();
    }
    else if(!/[A-Z]/.test(inputMdpc.value)){
        errorMdpc.innerHTML = " Le mot de passe doit contenir au moins 1 majuscule";
        errorMdpc.style.color ='red';
        e.preventDefault();
    }
    else if(!/[0-9]/.test(inputMdpc.value)){
        errorMdpc.innerHTML = " Le mot de passe doit contenir au moins 1 chiffre";
        errorMdpc.style.color ='red';
        e.preventDefault();
    }
    else if(inputMdpc.value == inputMdp.value){
        errorMdpc.innerHTML = "Confirmation Valide";
        errorMdpc.style.color = "green";
        e.preventDefault();
    }
    else{
        errorMdpc.innerHTML = "Confirmation non Valide";
        errorMdpc.style.color = "red";
        e.preventDefault();
    }
});



