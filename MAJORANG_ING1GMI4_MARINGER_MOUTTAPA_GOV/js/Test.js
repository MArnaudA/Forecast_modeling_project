function zoom(image){
            image.style.width = (image.width * 1.5) + "px";
            image.style.height = (image.weight * 1.5) + "px"
}

function toggle(){
    for(i = 0 ; i < document.getElementsByClassName('quantite').length ; i++){
        document.getElementsByClassName("quantite")[i].style.display = document.getElementsByClassName('quantite')[i].style.display == 'revert' ? "none" : "revert";
    }
}

function moins(id){
     var x = parseInt(document.getElementById(id).innerHTML);
     if(x>0){
        document.getElementById(id).innerHTML=x-1;
     }
}

function plus(id,idStock){
    var x = parseInt(document.getElementById(id).innerHTML);
    var y = parseInt(document.getElementById(idStock).innerHTML);
    if(x<y){
    document.getElementById(id).innerHTML=x+1;
    }
}

function change(){
    var btn = document.getElementById("stockbutton");
    if (btn.value == "Cacher") {
        btn.value = 'Afficher'
        btn.innerHTML = 'Afficher les quantités restantes';
    }
    else {
        btn.value = 'Cacher'; 
        btn.innerHTML = 'Cacher les quantités restantes';
    }
}