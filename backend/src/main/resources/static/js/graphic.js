window.onload = function () {
    debugger
    var id = document.body.getAttribute('idUser')
    $('#spinner').show();
    $.ajax({
        type: "GET",
        url: "https://localhost:8443/users/" + id + "/grafic",
        dataType: 'html',
        success: function (data) {
            debugger
            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                exportEnabled: true,
                theme: "light1",
                title: {
                    text: "Simple Column Chart with Index Labels"
                },
                data: [{
                    type: "column",
                    indexLabelFontColor: "#5A5757",
                    indexLabelFontSize: 16,
                    indexLabelPlacement: "outside",
                    dataPoints: [
                        {x: 10, y: 71},
                        {x: 20, y: 55},
                        {x: 30, y: 50},
                        {x: 40, y: 65},
                        {x: 50, y: 92, indexLabel: "\u2605 Highest"},
                        {x: 60, y: 68},
                        {x: 70, y: 38},
                        {x: 80, y: 71},
                        {x: 90, y: 54},
                        {x: 100, y: 60},
                        {x: 110, y: 36},
                        {x: 120, y: 49},
                        {x: 130, y: 21, indexLabel: "\u2691 Lowest"}
                    ]
                }]
            });
            chart.render();
            $('#spinner').hide();
        },
        error: function (data) {
            ('#spinner').hide();
        }
    });
}
