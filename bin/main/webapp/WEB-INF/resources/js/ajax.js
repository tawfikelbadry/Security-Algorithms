$(document).ready(function () {


    // code for combination request to encrypt msg
    $("#combin_btn_ecncryptor").click(function (event) {
        event.preventDefault();
        var plain = document.getElementById("combin_input_encryptor").value;
        console.log(plain);
        $.ajax({
            url: "combinationEncryption",
            type: 'POST',
            data: {'plaintext': plain},
            success: function (data, textStatus, jqXHR) {
                document.getElementById("combin_result_encryptor").innerHTML = data;
                console.log(data);
            }
        });

    });

    $("#combin_btn_decryptor").click(function (event) {
        event.preventDefault();
        var cipher = document.getElementById("combin_input_decryptor").value;
        console.log(cipher);
        $.ajax({
            url: "combinationDecryption",
            type: 'POST',
            data: {'cipherText': cipher},
            success: function (data, textStatus, jqXHR) {
                document.getElementById("combin_result_decryptor").innerHTML = data;
                console.log(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                document.getElementById("combin_result_decryptor").innerHTML = errorThrown;

            }

        });

    });

///////////////////////////////////////////////////////////////////////////

    $("#pfe_butn").click(function (event) {
        event.preventDefault();
        var plain = $("#pfe_plain_input").val();
        var key = $("#pfe_key_input").val();
        console.log("plain " + plain);
        console.log("key " + key);

        $.ajax({
            url: "playfairEncryption",
            data: {
                'plainText': plain,
                'key': key
            },
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                $("#pfe_result").html(data);
                console.log(data);
            }

        });

    });

    $("#pfd_butn").click(function (event) {
        event.preventDefault();
        var cipher = $("#pfd_cipher_input").val();
        var key = $("#pfd_key_input").val();
        console.log("cipher " + cipher);
        console.log("key " + key);

        $.ajax({
            url: "playfairDecryption",
            data: {
                'cipherText': cipher,
                'key': key
            },
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                $("#pfd_result").html(data);
                console.log(data);
            }

        });

    });

    ///////////////////////////////////////////////////////////////////////////

    $('#btnHellEncrypt').click(function (event) {
        event.preventDefault();
        var plain = $("#hellTextInput").val();
        var n = $("#hellMatrixnumber").val();
        var matrixInputs = new Array(n);
        console.log(plain);
        console.log(n);
        for (var i = 0; i < n; i++) {
            matrixInputs[i] = new Array(n);
            for (var l = 0; l < n; l++) {
                var id = "#matrix" + i + "" + l;
                matrixInputs[i][l] = $(id).val();
            }
        }
        var data = [];
        var index = 0;
        for (var i = 0; i < matrixInputs.length; i++) {
            for (var j = 0; j < matrixInputs[i].length; j++) {
                data[index] = matrixInputs[i][j];
                index++;
            }

        }

        $.ajax({
            url: "hellcipherEncryption",
            type: 'POST',
            data: {
                'plain': plain,
                'key': data,
                'n': n
            }, success: function (data, textStatus, jqXHR) {
                $("#hellEncryptResult").html(data);
                console.log(data);
            }, error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
            }

        });

    });


    $("#btnHellDecrypt").click(function (event) {
        event.preventDefault();
        var plain = $("#hellcipherInput").val();
        var n = $("#hellMatrixnumbercipher").val();
        var matrixInputs = new Array(n);
        console.log(plain);
        console.log(n);
        for (var i = 0; i < n; i++) {
            matrixInputs[i] = new Array(n);
            for (var l = 0; l < n; l++) {
                var id = "#matrixDecrypt" + i + "" + l;
                matrixInputs[i][l] = $(id).val();
            }
        }
        var data = [];
        var index = 0;
        for (var i = 0; i < matrixInputs.length; i++) {
            for (var j = 0; j < matrixInputs[i].length; j++) {
                data[index] = matrixInputs[i][j];
                index++;
            }

        }

        $.ajax({
            url: "hellcipherDecryption",
            type: 'POST',
            data: {
                'cipher': plain,
                'key': data,
                'n': n
            }, success: function (data, textStatus, jqXHR) {
                $("#hellDecryptResult").html(data);
            }, error: function (jqXHR, textStatus, errorThrown) {
                console.log(errorThrown);
            }

        });


    });




});


