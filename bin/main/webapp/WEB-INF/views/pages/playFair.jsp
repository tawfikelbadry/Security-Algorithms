<div role="tabpanel" class="tab-pane fade " id="fair">
    <h2>Play Fair Algorithm</h2>
    <ul class="security">
        <li class="active">
            <a href="#fairenc" role="tab" data-toggle="tab">Encrption</a>
        </li>
        <li>
            <a href="#fairdec" role="tab" data-toggle="tab">Decription</a>
        </li>
    </ul>
    <div class="tab-content content ">
        <div id="fairenc" role="tabpanel" class="tab-pane fade in active">
            <div class="row">
                <form >
                    <div class="col-md-6">
                        <div class="group">      
                            <input type="text" required name="plainText" id="pfe_plain_input">
                            <span class="bar"></span>
                            <label>Entre Message Want To Encription</label>
                        </div>
                    </div> <!-- End Col -->
                    <div class="col-md-6">
                        <div class="group">      
                            <input type="text" required id="pfe_key_input">
                            <span class="bar"></span>
                            <label>Entre The Key</label>
                        </div>
                    </div> <!-- End Col -->
                    <button class="btn" id="pfe_butn">
                        Encrypt
                        <i class="fa fa-lock" aria-hidden="true"></i>
                    </button>
                    <div class="result">
                        <h3>Result IS :</h3>
                        <h4 id="pfe_result"> </h4>
                    </div> <!-- end result -->
                </form>
            </div> <!-- end Row -->
        </div> <!-- End fairenc -->
        <div id="fairdec" role="tabpanel" class="tab-pane fade">
            <div class="row">
                <form >
                    <div class="col-md-6">
                        <div class="group">      
                            <input type="text" required name="cipherText" id="pfd_cipher_input">
                            <span class="bar"></span>
                            <label>Entre Message Want To Decription</label>
                        </div>
                    </div> <!-- End Col -->
                    <div class="col-md-6">
                        <div class="group">      
                            <input type="text" required name="key" id="pfd_key_input">
                            <span class="bar"></span>
                            <label>Entre The Key</label>
                        </div>
                    </div> <!-- End Col -->
                    <button class="btn" id="pfd_butn">
                        Decrypt
                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    </button>
                    <div class="result">
                        <h3>Result IS :</h3>
                        <h4 id="pfd_result" ></h4>
                    </div> <!-- end result -->
                </form>
            </div> <!-- end Row -->
        </div> <!-- End fairenc -->
    </div>

</div> <!-- End play fair-->