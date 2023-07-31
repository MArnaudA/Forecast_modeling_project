let formConnexion = document.getElementById('formConnexion');
    formConnexion.addEventListener("submit", function(e){
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


