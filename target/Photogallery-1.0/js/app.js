var photogallery = angular.module('photogallery', ['ngRoute', 'ngStorage']);

photogallery.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/login', {
                    templateUrl: 'partials/login.html',
                    controller: 'LoginCtrl'
                }).
                when('/registrazione', {
                    templateUrl: 'partials/registrati.html',
                    controller: 'registratiCtrl'
                }).
                when('/home', {
                    templateUrl: 'partials/home.html',
                    controller: 'HomeCtrl'
                }).
                when('/creaAlbum', {
                    templateUrl: 'partials/creaAlbum.html',
                    controller: 'CreaAlbumCtrl'
                }).
                when('/listaAlbum', {
                    templateUrl: 'partials/listaAlbum.html',
                    controller: 'VisualizzaCtrl'
                }).
//                aggiunto da cristian
                when('/caricaFoto/:nome',{
                    temlplateUrl: 'partials/caricaFoto.html',
                    controller: 'CaricaFotoCtrl'
                }).
                otherwise({
                    redirectTo: '/login'
                });
    }]);

