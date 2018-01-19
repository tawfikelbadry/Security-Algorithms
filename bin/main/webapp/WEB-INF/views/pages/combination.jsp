<div role="tabpanel" class="tab-pane fade " id="combination">
    <h2>Combination Algorithm</h2>
    <ul class="security">
        <li class="active">
            <a href="#comenc" role="tab" data-toggle="tab">Encrption</a>
        </li>
        <li>
            <a href="#comdec" role="tab" data-toggle="tab">Decription</a>
        </li>
    </ul>
    <div class="tab-content content ">

        <!-- start encryption div -->
        <div id="comenc" role="tabpanel" class="tab-pane fade in active">
            <div class="row">
                <form>
                    <div class="col-md-12">
                        <div class="group">      
                            <input type="text" required name="plaintext" id="combin_input_encryptor">
                            <span class="bar"></span>
                            <label>Enter Message Want To Encrypt </label>
                        </div>
                    </div> <!-- End Col -->

                    <button class="btn" id="combin_btn_ecncryptor">
                        Encrypt
                        <i class="fa fa-lock" aria-hidden="true"></i>
                    </button>
                    <div class="result">
                        <h3>Result IS :</h3>                       
                        <h4 id="combin_result_encryptor" > </h4>
                    </div> <!-- end result -->
                </form>
            </div> <!-- end Row -->
        </div> <!-- End fairenc -->

        <!-- start decryption div -->
        <div id="comdec" role="tabpanel" class="tab-pane fade">
            <div class="row">
                <form >
                    <div class="col-md-12">
                        <div class="group">      
                            <input type="text" required id="combin_input_decryptor">
                            <span class="bar"></span>
                            <label>Enter Message Want To Decrypt</label>
                        </div>
                    </div> <!-- End Col -->

                    <button class="btn" id="combin_btn_decryptor">
                        Decrypt
                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    </button>
                    <div class="result">
                        <h3>Result IS :</h3>
                        <h4 id="combin_result_decryptor"> </h4>
                    </div> <!-- end result -->
                </form>
            </div> <!-- end Row -->
        </div> <!-- End fairenc -->
    </div>
</div> <!-- End combination -->
