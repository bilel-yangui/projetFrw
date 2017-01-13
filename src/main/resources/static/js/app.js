var app=angular.module("MyApp",['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	
	$stateProvider.state('home',{
		url:'/home',
		templateUrl:'views/home.html',
		controller:'HomeController'
	});
	
	$stateProvider.state('chercher',{
		url:'/chercher',
		templateUrl:'views/chercher.html',
		controller:'MyController'
	});
	
	$stateProvider.state('NewProduit',{
		url:'/NewProduit',
		templateUrl:'views/NewProduit.html',
		controller:'NewProduitController'
	});
	
});



app.controller("HomeController",function($scope,$http){
	
});
app.controller("NewProduitController",function($scope,$http){
	$scope.produit={};
	$scope.mode=0;
	$scope.modeForm=function(){
		$scope.produit={};
		$scope.mode=0;
	}
	$scope.saveProduit=function(){
		$http.post("http://localhost:8383/ProduitR",$scope.produit).
		then(function(response) {
	       $scope.produit=response.data;
	       $scope.mode=1;
	    });	
	}
	
	
});

app.controller("MyController",function($scope,$http){
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=4;
	$scope.pages=[];
	$scope.chercherProduit=function(){
		$http.get("http://localhost:8383/chercherProduits?mc="+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size).
	    then(function(response) {
	        $scope.pageProduits = response.data;
	        $scope.pages=new Array(response.data.totalPages)
	    });	
	}
	$scope.getProduit=function(){
		$scope.pageCourante=0;
		$scope.chercherProduit();
	}
	
	$scope.gotoPage=function(p){
		$scope.pageCourante=p;
		$scope.chercherProduit();
	}

});