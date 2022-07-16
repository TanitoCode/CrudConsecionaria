function guardar() {

    let marca = document.getElementById("txtMarca").value
    let modelo = document.getElementById("txtModelo").value
    let color = document.getElementById("txtColor").value
    let km = parseInt(document.getElementById("txtKm").value)
    let anio = document.getElementById("txtAnio").value   
    let precio = parseInt(document.getElementById("txtPrecio").value)
    let foto = document.getElementById("txtFoto").value

    let auto = {
        marca: marca,
        modelo: modelo,
        color: color,
        km: km,
        anio: anio,
        precio: precio,
        foto: foto
    }
    let url = "http://localhost:8080/autos"
    var options = {
        body: JSON.stringify(auto),
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
       // redirect: 'follow'
    }
    fetch(url, options)
        .then(function () {
            console.log("creado")
            alert("Grabado")

            // Handle response we get from the API
        })
        .catch(err => {
            //this.errored = true
            alert("Error al grabar" )
            console.error(err);
        })
}
