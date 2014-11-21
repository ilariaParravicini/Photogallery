photogallery.controller('VisualizzaCtrl', function ($scope, dataServices, $sessionStorage, $routeParams, $location) {

    var visualizzaAlbumCallback = function (risposta) {
        if (risposta.codice === 0) {
            $scope.album = risposta.risultato;
        }
        else
            $scope.messaggio = risposta.messaggio;
    };

    dataServices.getAlbum(visualizzaAlbumCallback);
});