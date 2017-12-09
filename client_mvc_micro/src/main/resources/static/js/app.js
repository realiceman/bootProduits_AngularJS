var app=angular.module("MyApp",['ui.router']);

app.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state("produits",{
		url:"/produits",
		templateUrl: "views/produits.html",
		controller: "ProduitController"
	});
	$stateProvider.state("categories",{
		url:"/categories",
		templateUrl: "views/categories.html",
		controller: "CategoriesController"
	});
	
	$urlRouterProvider.otherwise("produits");
});


app.controller("ProduitController", function(){
	
});


app.controller("ProduitController", function($scope, $http){
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=4;
	$scope.pages=[];
	$scope.afficher = function(){

		$http.get("chercher?mc="+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size)
		.success(function(data){
			$scope.pageProduits=data;
			$scope.pages=new Array(data.totalPages);
		})
		.error(function(err){
			console.log(err);
		})
	}
	
	
	$scope.goToPage=function(p){
		$scope.pageCourante=p;
		$scope.afficher();
	}
	
});