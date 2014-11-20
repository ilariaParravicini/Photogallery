photogallery.factory('dataServices', function($http, $sessionStorage) {
    var login = function(utente, loginCallback) {
        $http.post('rest/accedi', utente).
                success(function(data, status, headers, config) {
                    loginCallback(data);
                });
    };
            
    return {
        login: login,
       
    };
});
