(function() {
'use strict';

angular.module('transpordiapp', [])
	.constant("hostname", "localhost")
	.controller('TransferController', TransferController)
	.controller('TimesController', TimesController)
	.service('TransferService', TransferService)
	.service('TimesService', TimesService)
	.directive('addCountryDirective', addCountryDirective);


	TransferController.$inject = ['TransferService'];

	function TransferController (TransferService) {
		var tf = this;

		tf.address;
		tf.openhoursbegin;
		tf.openhoursend;
		tf.active;
		tf.score;


		tf.addNewTransfer = function () {
			var promise = TransferService.addNewTransfer(tf);

			promise.then(function (response) {
			    tf.result = response;
			    console.log("Data was posted: ", tf.result);
			})
			.catch(function (error) {
			    console.log("ERROR!");
			    console.log(error);
			})

		};
	};


	TimesController.$inject = ['TimesService'];

	function TimesController (TimesService) {
	    var tc = this;
	    var promise = TimesService.getNormalOpenTimes();

	    promise.then(function (response) {
	    tc.normalOpenTimes = response.data;
	    console.log(tc.normalOpenTimes);

	    if (response.data.length === 0) {
	        console.log("NOTHING in response");
	        }
	    })
	    .catch(function (error) {
	        console.log("ERROR");
	        console.log(error);
	     });

	    promise = TimesService.getLongOpenTimes();

	    promise.then(function (response) {
	    tc.longOpenTimes = response.data;
	    console.log(tc.longOpenTimes);

	    if (response.length === 0) {
	        console.log("NOTHING in response");
	        }
	    })
	    .catch(function (error) {
	        console.log("ERROR");
	        console.log(error);
	     });

	};

	TransferService.$inject = ['$http'];

	function TransferService ($http) {
		var service = this;

        service.addNewTransfer = function (tf) {
            console.log("adding: ");
            console.log(tf);
            return $http({
                method: "POST",
                url: ("http://localhost:8080/transfers"),
                data: JSON.stringify(tf),
                headers: {
                            'Content-Type': 'application/json'
                            }
            }).then(function (result) {
                return result;
            })
        };
	};

	TimesService.$inject = ['$http'];

	function TimesService ($http) {
	    var service = this;

	    service.getNormalOpenTimes = function () {
	        console.log("data received n");
			return $http({
				method: "GET",
				url: ("http://localhost:8080/transfers/times/normal")
			}).then(function (result) {
				//result processing, keep matching items if selected query
				console.log("Data n:");
				console.log(result);
				return result;
			})
	    }

	    service.getLongOpenTimes = function () {
	        console.log("data received l");
			return $http({
				method: "GET",
				url: ("http://localhost:8080/transfers/times/long")
			}).then(function (result) {
				//result processing, keep matching items if selected query
				console.log("Data l:");
				console.log(result);
				return result;
			})
	    }
	}


	function addCountryDirective () {
		return {
			template: ', Estonia'
		};
	};

})();