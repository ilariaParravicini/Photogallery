photogallery.controller('LoginCtrl', function($scope, dataServices, $location, $sessionStorage) {
    var loginCallback = function(risposta) {
        if (risposta.codice === 0) {
            $sessionStorage.utente = risposta.risultato;
            $scope.messaggio = risposta.messaggio;
            $location.path('/home');
        } else{
            $scope.messaggio = risposta.messaggio;
        }            
    };
    
    $scope.login=function(utente) {
        dataServices.login(utente, loginCallback);
    };
});
    


