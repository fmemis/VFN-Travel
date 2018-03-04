    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Site name</title>
	    <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href='http://fonts.googleapis.com/css?family=Arizonia' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/payment.css" type="text/css">
	    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
	    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>

	    <script>
	      $(function(){
	       $("#NavBar").load("NavBar.jsp");
	     });
	        </script>
	    

    </head>
    <body style = "background:#e2edff">

    <div id = "NavBar"></div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-2 col-md-4 col-md-offset-2">
                <div class="container">
        <div class="row">
            <!-- You can make it whatever width you want. I'm making it full width
                 on <= small devices and 4/12 page width on >= medium devices -->
            <div class="col-xs-12 col-md-4" id = "second" style = "display:none">


                <!-- CREDIT CARD FORM STARTS HERE -->
                <div class="panel panel-default credit-card-box" style = "background:#f7faff; border-color:transparent">
                    <div class="panel-heading display-table" style = "background:#f7faff;">
                        <div class="row display-tr" >
                            <h3 class="panel-title display-td" >Payment Details</h3>
                            <div class="display-td" >
                                <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form id="payment-form" method="post" action="Reservation">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label for="cardNumber">CARD NUMBER</label>
                                        <div class="input-group">
                                            <input type="tel"class="form-control"name="cardNumber"placeholder="Valid Card Number"autocomplete="cc-number"required autofocus />
                                            <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-7 col-md-7">
                                    <div class="form-group">
                                        <label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
                                        <input type="tel" class="form-control" name="cardExpiry"placeholder="MM / YY"autocomplete="cc-exp"required />
                                    </div>
                                </div>
                                <div class="col-xs-5 col-md-5 pull-right">
                                    <div class="form-group">
                                        <label for="cardCVC">CV CODE</label>
                                        <input type="tel" class="form-control"name="cardCVC"placeholder="CVC"autocomplete="cc-csc"required/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label for="couponCode">COUPON CODE</label>
                                        <input type="text" class="form-control" name="couponCode" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <button class="subscribe btn btn-primary btn-lg btn-block" type="submit">Pay Now</button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12">
                                    <hr>
      </form>
                                </div>
                            </div>
                    </div>
                </div>
                <!-- CREDIT CARD FORM ENDS HERE -->


            </div>

        </div>

        <div class="col-xs-12 col-md-4" id = "initial">
                <div class="well" style = "background:#f7faff; border-color:transparent">
                    <h3>Terms & conditions</h3>
                    1. Pets: ${pets}
                    <br>
                    2. Smoking: Not allowed
                    <br>
                    3. Pay for any property damage you cause

                <hr>
                <form>
                    <div class="checkbox">
                      <label><input type="checkbox" id="tick" onchange="document.getElementById('terms').disabled = !this.checked;"/>I agree</label>
                    </div>
                </form>
                <hr>
                <button class = "btn btn-primary" onclick="show('second')" name="terms" id="terms" disabled >Continue</button>
                </div>
            </div>

       <script>
      function show(param_div_id) {
        document.getElementById('initial').innerHTML = document.getElementById(param_div_id).innerHTML;
      }
    </script>

    </div>
            </div>
            <div class="col-lg-4 col-md-4">
                <div class="well" style = "background:#f7faff; border-color:transparent;">
                <div class="container">
                    <div class="col-md-2 col-lg-2" style="padding-left: 0px;  padding-right: 0px;">
                        <img src="images/snow.jpg" class="img-responsive">
                    </div>
                </div>
                    <hr>
                    <div class="container" >
                      <p><span class="glyphicon glyphicon-user" style="color:#006dcc"></span> <%= session.getAttribute("guests")%></p>
                      <p><span class="glyphicon glyphicon-calendar" style="color:#006dcc"></span> Date: <%= session.getAttribute("arrival")%> - <%= session.getAttribute("departure")%></p>
                    </div>

                    <hr>
                    <h4>Total: ${price} &euro;</h4>
                </div>
            </div>
        </div>
    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    </body>
    </html>