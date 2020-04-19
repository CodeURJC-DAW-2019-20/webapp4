window.onload = function () {
    var id = document.body.getAttribute('idUser')
   
    $.ajax({
        type: "GET",
        url: "https://localhost:8443/api/users/" + id + "/grafic",
        success: function (data) {
        	var objData = JSON.parse(data);
        	objData = convertData(objData);
            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                exportEnabled: true,
                theme: "light1",
                title: {
                    text: "Gráfico de valoraciones de apuntes"
                },
                axisX:{
                	   labelFontColor: "transparent",
                },
                data: [{
                    type: "column",
                    indexLabelFontColor: "#5A5757",
                    indexLabelFontSize: 16,
                    indexLabelPlacement: "outside",
                    dataPoints: objData
                }]
            });
            chart.render();
            
        },
        error: function (data) {
            
        }
    });
    
    function convertData(objData){
    	for(var i = 0; i < objData.length; i++){
    		objData[i] = {x: i+1, y: objData[i].value, indexLabel: objData[i].name};
    	}
    	return objData;
    }
}
