angular.module('app').controller('EmployeesCtrl', ['$scope', '$http', '$uibModal', function($scope, $http, $uibModal){
    $scope.settings = {
            loadingDone : false
    };

    $scope.loadData = function(){
        console.log('load data');
        $http.post('/test/get_all_employees.json').then(function(response){
            processServerResponse(response.data, null, function(data){
            	$scope.employeesList = data.employeesList;
            	$scope.employeeForm = data.employeeForm;
            }, true);
        });
    };

    $scope.loadData();

    $scope.openModal = function(id) {
        var modalInstance = $uibModal.open({
          animation: 'true',
          templateUrl: 'saveEmployeeModal.html',
          controller: 'SaveEmployeeCtrl',
          size: 'medium',
          resolve: {
        	  employeeForm : function(){
                      return $scope.employeeForm;
              },
              id : function(){
                  return id;
              }
          }
    });
        modalInstance.result.then(function (data) {
            $scope.loadData();
        }, function () {
            console.log('cancel');
        });
    };

    $scope.del = function(id){
    	$http.post('/test/delete_employee.json', id).then(function(response){
            processServerResponse(response.data, null, function(data){
            	$scope.loadData();
            }, false);
        });
    };

}]).controller('SaveEmployeeCtrl', ['$scope', '$uibModalInstance', '$http', 'employeeForm', 'id', function($scope, $uibModalInstance, $http, employeeForm, id){

    if(id != null){
    	$http.post('/test/get_employee.json', id).then(function(response){
            processServerResponse(response.data, null, function(data){
            	$scope.employeeForm = data.employeeForm;
            }, true);
        });
    }else{
        $scope.employeeForm = employeeForm;
    }

    $scope.save = function (){
        $http.post('/test/save_employee.json', $scope.employeeForm).then(function(response){
            processServerResponse(response.data, null, function(data){
            	$uibModalInstance.close(data);
            }, false);
        });
    };

    $scope.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };
}]);