photogallery.factory('dataServices', function($http, $sessionStorage) {
    var login = function(utente, loginCallback) {
        $http.post('rest/accedi', utente).
                success(function(data, status, headers, config) {
                    loginCallback(data);
                });
    },
            creaUtente = function(utente, creaUtenteCallback) {
                $http.post('rest/registrati', utente).
                        success(function(data, status, headers, config) {
                            creaUtenteCallback(data);
                        });
            },
            creaAlbum = function(album, CreaAlbumCallback) {
                $http.post('rest/creaAlbum', album).
                        success(function(data, status, headers, config) {
                            CreaAlbumCallback(data);
                        });
            };

    return {
        login : login,
        creaUtente : creaUtente,
        creaAlbum : creaAlbum

    };
});