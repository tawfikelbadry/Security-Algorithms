<div role="tabpanel" class="tab-pane fade in active" id="hell">
    <h2>Hell Cipher Algorithm</h2>
    <ul class="security">
        <li class="active">
            <a href="#hellenc" role="tab" data-toggle="tab">Encrption</a>
        </li>
        <li>
            <a href="#helldec" role="tab" data-toggle="tab">Decription</a>
        </li>
    </ul>
    <div class="tab-content content ">
        <div id="hellenc" role="tabpanel" class="tab-pane fade in active">
            <div class="row">
                <form>
                    <div class="col-md-12">
                        <div class="group">      
                            <input type="text" required id="hellTextInput">
                            <span class="bar"></span>
                            <label>Enter Message Want To Encrypt</label>
                        </div>
                    </div> <!-- End Col -->
                    <div class="col-md-3">
                        <div class="group">      
                            <input type="text" required id="hellMatrixnumber">
                            <span class="bar"></span>
                            <label>Enter N Matrix (n*n)</label>
                        </div>
                    </div> <!-- End Col -->
                    <div class="col-md-2">
                        <a class="btn calc" id="btnMatrixCreate">Create<i class="fa fa-plus"></i></a>
                    </div> <!-- End Col -->
                    <div class="col-md-12">
                        <div align="center">
                            <div class="matrix" id="matrixEncrypt">

                            </div>
                        </div> <!-- End Center -->
                    </div> <!-- end Col -->
                    
                    <div class="col-md-12">
                        <button class="btn" id="btnHellEncrypt">
                            Encrypt
                            <i class="fa fa-lock" aria-hidden="true"></i>
                        </button>
                        <div class="result">
                            <h3>Result IS :</h3>
                            <h4 id="hellEncryptResult"></h4>
                        </div> <!-- end result -->
                    </div> <!-- end Col-->
                </form>
            </div> <!-- end Row -->
        </div> <!-- End fairenc -->
        <div id="helldec" role="tabpanel" class="tab-pane fade">
            <div class="row">
                <form>
                    <div class="col-md-12">
                        <div class="group">      
                            <input type="text" required id="hellcipherInput">
                            <span class="bar"></span>
                            <label>Entre Message Want To Decription</label>
                        </div>
                    </div> <!-- End Col -->
                    <div class="col-md-3">
                        <div class="group">      
                            <input type="text" required id="hellMatrixnumbercipher" >
                            <span class="bar"></span>
                            <label>Entre N Matix (n*n)</label>
                        </div>
                    </div> <!-- End Col -->
                    <div class="col-md-2">
                        <a class="btn calc" id="btnDecryptMatrixCreate">Create<i class="fa fa-plus"></i></a>
                    </div> <!-- End Col -->
                    <div class="col-md-12">
                        <div align="center">
                            <div class="matrix" id="matrixDecrypt">

                            </div>
                        </div> <!-- End Center -->
                    </div> <!-- end Col -->
                    <div class="col-md-12">
                        <button class="btn" id="btnHellDecrypt">
                            Decrypt
                            <i class="fa fa-lock" aria-hidden="true"></i>
                        </button>
                        <div class="result">
                            <h3>Result IS :</h3>
                            <h4 id="hellDecryptResult"></h4>
                        </div> <!-- end result -->
                    </div> <!-- end Col-->
                </form>
            </div> <!-- end Row -->
        </div> <!-- End fairenc -->
    </div>
</div> <!-- End hell ciper -->

