/*global $ */
$(document).ready(function () {
    "use strict";
    $(".tab-content > i").click(function () {
        $(".tab-content").toggleClass("active");
        $("ul.header").toggleClass("active");
        $(this).toggleClass("fa-times").toggleClass("fa-bars");
    });
    $("ul.header > li > a").click(function () {
        $(".tab-content").toggleClass("active");
        $("ul.header").toggleClass("active");
        $(".tab-content > i").toggleClass("fa-times").toggleClass("fa-bars");
    });

});
$(document).ready(function () {
    "use strict";
    $("#btnMatrixCreate").click(function () {
        var value = document.getElementById('hellMatrixnumber').value;
//        $(".btn.calc").remove();
        console.log("enterd");
        var matrixInputId = '';
        var i, x;
        for (i = 0; i < value; i++) {
            for (x = 0; x < value; x++) {
                var matrixInputId = 'matrix' + i + '' + x;
                $("#matrixEncrypt").append('<div class="group"><input type="text" id="' + matrixInputId + '" required><span class="bar"></span></div>');

            }
            $("#matrixEncrypt").append("<br>");
        }

    });


    $("#btnDecryptMatrixCreate").click(function () {

        var value = document.getElementById('hellMatrixnumbercipher').value;

        var matrixInputId = '';
        var i, x;
        for (i = 0; i < value; i++) {
            for (x = 0; x < value; x++) {
                var matrixInputId = 'matrixDecrypt' + i + '' + x;
                $("#matrixDecrypt").append('<div class="group"><input type="text" id="' + matrixInputId + '" required><span class="bar"></span></div>');

            }
            $("#matrixDecrypt").append("<br>");
        }


    });

});


