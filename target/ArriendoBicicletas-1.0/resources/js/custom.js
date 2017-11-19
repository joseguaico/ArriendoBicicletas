function dvAllowed(evt) 
{    
    var key = window.event ? evt.keyCode : evt.which;

    if ((key === 8 || key === 46 || key === 9 || key === 0) || ((key >= 48 && key <= 57) || (key >= 96 && key <= 105))) { 
        return true;
    }
    // 0-9, K, k
    var reg = new RegExp('([0-9]|k|K)');
    var texto = String.fromCharCode(key);

    if(reg.test(texto))  {
        return true;
    }else{
        return false;
    }
}

