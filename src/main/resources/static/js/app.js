var app =angular.module("MyApp",['ui.router']);
app.config(function($stateProvider,$urlRouterProvider){
	$stateProvider.state("home",{
		url:"/home",
		templateUrl:"views/home.html",
			controller:"HomeController"
	});
	$stateProvider.state("chercher",{
		url:"/chercher",
		templateUrl:"views/chercher.html",
			controller:"MyController"
	});
	$stateProvider.state("newProduit",{
		url:"/newProduit",
		templateUrl:"views/NewProduit.html",
			controller:"NewProduitController"
	});
	
});

app.controller('HomeController',function(){
	
});
app.controller('NewProduitController',function($scope,$http){
	$scope.produit={ 
			"codeEan13": "0000000000000",
			"description": "",
			"productName": ""};
	$scope.mode=0;
	$scope.saveProduit=function(){
		$http.post('http://localhost:8080/produits',$scope.produit)
		.success(function(data){
			$scope.produit=data;
			$scope.mode=1;
		})
		.error(function(err){
			console.log(err);
		});
	}
	$scope.modeForm=function(){
		$scope.produit={
			   "codeEan13": "0000000000000",
				"description": "",
				"productName": ""
				};
		$scope.mode=0;
	}
});

app.controller("MyController",function($scope,$http){
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.motCleName="";
	$scope.pageCourante=0;
	$scope.size=4;
	$scope.pages=[];
	$scope.pages2=[];
	

	$scope.lookupByDescription=function(){
		$http.get("http://localhost:8080/lookupByDescription?mc="+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size)
		
		.success(function(data){
	   	 $scope.pageProduits=data;
	   	 $scope.pages=new Array(data.totalPages)
		 
	    })
	    .error(function(err){
	    	console.log(err);
	    })
	}
	
	$scope.lookupByName=function(){
		$http.get("http://localhost:8080/lookupByName?mc="+$scope.motCleName+"&page="+$scope.pageCourante+"&size="+$scope.size)
		
		.success(function(data){
	   	 $scope.pageProduits=data;
	   	 $scope.pages2=new Array(data.totalPages)
		 
	    })
	    .error(function(err){
	    	console.log(err);
	    })
	}
	
	$scope.getProduitsByName=function(){
		$scope.pageCourante=0;
		$scope.lookupByName();
	}
	
	$scope.getProduits=function(){
		$scope.pageCourante=0;
		$scope.lookupByDescription();
	}
	
	
	
	
	$scope.goToPage=function(p){
		
		$scope.pageCourante=p;
		$scope.lookupByDescription();
		$scope.lookupByName();
	}
	
});

