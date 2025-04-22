<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Set Password</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="Set Password.css">
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="row border rounded-5 p-3 bg-white shadow box-area">
            <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style="background: #103cbe;">
                <div class="featured-image mb-3">
                    <img src="images/1.png" class="img-fluid" style="width: 250px;">
                </div>
                <p class="text-white fs-2" style="font-family: 'Courier New', Courier, monospace; font-weight: 600;">Be Verified</p>
                <small class="text-white text-wrap text-center" style="width: 17rem;font-family: 'Courier New', Courier, monospace;">Join experienced Designers on this platform.</small>
            </div> 
            <div class="col-md-6 right-box">
                <div class="row align-items-center">

                    <!-- Form 1: For Sending OTP -->
                    <form action="userSet_PasswordEmail" method="post">
                        <div class="header-text mb-4">
                            <h2>Send OTP</h2>
                            <p>Enter your email to receive the OTP.</p>
                        </div>
                        <div class="input-group mb-3">
                            <input type="text" id="email" name="email" class="form-control form-control-lg bg-light fs-6" placeholder="Email address" required>
                        </div>
                        <input type="submit" value="Send OTP" class="btn btn-lg btn-primary mb-3" />
                    </form>

                    <!-- Form 2: For Password Reset -->
                    <form action="setPassword" method="post">
                        <div class="header-text mb-4">
                            <h2>Set Password</h2>
                            <p>Enter your new password and OTP to reset.</p>
                        </div>
                        <!-- Reuse the Email Field -->
                        <div class="input-group mb-3">
                            <input type="text" id="email" name="email" class="form-control form-control-lg bg-light fs-6" placeholder="Email address" required>
                        </div>
                        <div class="input-group mb-3">
                            <input type="password" id="password" name="password" class="form-control form-control-lg bg-light fs-6" placeholder="New Password" required>
                        </div>
                        <div class="input-group mb-1">
                            <input type="password" id="confirm-password" name="confirm-password" class="form-control form-control-lg bg-light fs-6" placeholder="Confirm Password" required>
                        </div>
                        <div class="input-group mb-1">
                            <input type="text" id="otp" name="otp" class="form-control form-control-lg bg-light fs-6" placeholder="Enter OTP" required>
                        </div>
                        <input class="btn btn-lg btn-primary w-100 fs-6" type="submit" value="Reset Password" />
                    </form>

                </div>
            </div> 
        </div>
    </div>
</body>
</html>
