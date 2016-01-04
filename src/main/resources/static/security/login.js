//TODO classify
function fbLogin(response) {
    console.log("Forward to authentication!");

    var accessToken = response.authResponse.accessToken;
    var userId = response.authResponse.userID;

    window.location="/auth/fb?accessToken="+accessToken+"&userId="+userId;
}