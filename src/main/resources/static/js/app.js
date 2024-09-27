function redirect(url){
    window.location.href = url;
}
function reload(){
    window.location.reload();
}
function get(url, callback, modal=null){
    fetch(url,{
        method: 'GET',
        headers: {
            'Content-Type':'application/json'
        }
    })
    .then(response => {
        return response.json().then(data => ({
            contenido: data,
            status: response.status
        }));
    })
    .then(data => callback(data, modal))
    .catch(error => {
        console.log(error);
    });
}
function post(url, payload, callback, modal=null){
    fetch(url,{
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(payload)
    })
    .then(response => {
        return response.json().then(data => ({
            contenido: data,
            status: response.status
        }));
    })
    .then(data => callback(data, modal))
    .catch(error => {
        console.log(error);
    });
}
function patch(url, payload, callback, modal=null){
    fetch(url,{
        method: 'PATCH',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(payload)
    })
    .then(response => {
        return response.json().then(data => ({
            contenido: data,
            status: response.status
        }));
    })
    .then(data => callback(data, modal))
    .catch(error => {
        console.log(error);
    });
}
function del(url, callback, modal=null){
    fetch(url,{
        method: 'DELETE',
        headers: {
            'Content-Type':'application/json'
        }
    })
    .then(response => {
        return {
               contenido: null,
               status: response.status
           };
    })
    .then(data => callback(data, modal))
    .catch(error => {
        console.log(error);
    });
}
function calcularFecha(fecha, cantidadHoras){
    let date = new Date(fecha);
    let milis = (date.getTime() - date.getTimezoneOffset() * 60000) + (3600000 * cantidadHoras);
    const newDate = new Date(milis);
    return newDate.toISOString().substring(0, 16);
}
function extraerFecha(fecha){
    return fecha.substring(0,10);
}
function extraerHora(fecha){
    return fecha.substring(11,16);
}