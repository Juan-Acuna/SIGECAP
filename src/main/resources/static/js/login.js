(()=>{
    "use strict";
    document.addEventListener("DOMContentLoaded",function(){
        let form = document.querySelector("form");
        form.onsubmit = (event)=>{
            event.preventDefault();
            let login = {
                email: form['email'].value,
                pwd: form['pwd'].value
            };
            post(form.action, login, (data) => {
                if(data.status==200){
                    redirect('/');
                } else {
                    alert(data.contenido.error);
                    console.log(data);
                }
            });
        }
    });
})();