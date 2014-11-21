photogallery.controller('CreaAlbumCtrl', function($scope, dataServices, $location, $sessionStorage) {
    var creaAlbumCallback = function(risposta) {
        if (risposta.codice === 0) {
            $scope.messaggio = risposta.messaggio;
//            $location.path('/home');
        } else
            $scope.messaggio = risposta.messaggio;
        
    };
    
    $scope.creaAlbum=function(album) {
        dataServices.creaAlbum(album, creaAlbumCallback);
    };
});


