photogallery.factory('dataServices', function($http, $sessionStorage) {
    var login = function(utente, loginCallback) {
        $http.post('rest/login', utente).
                success(function(data, status, headers, config) {
                    loginCallback(data);
                });

    },
            creaUtente = function(utente, creaUtenteCallback) {
                $http.post('rest/registrati', utente).
                        success(function(data, status, headers, config) {
                            creaUtenteCallback(data);
                        });
            };


    return {
        login: login,
        creaUtente: creaUtente
    };

});