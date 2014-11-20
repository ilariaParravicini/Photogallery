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
//                when('/logout', {
//                    templateUrl: 'partials/login.html',
//                    controller: 'HomeCtrl'
//                }).
                otherwise({
                    redirectTo: '/login'
                });
    }]);

