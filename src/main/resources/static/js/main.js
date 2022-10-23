(function ($) {
    // 리턴된 api 값
    var return_api = new Vue({
        el: '#return-api',
        data: {
            return_api : '',
            currency : ''
        }
    });

    // 계산 결과 값
    var calculate_result = new Vue({
        el: '#calculate-result',
        data: {
            calculate_result : ''
        }
    });

    $("#submit").click(function () {
        const query = return_api.return_api;
        const insertValue = $("#usd").val();
        const usd = $("#country option:selected").val();
        if(insertValue == 0 || insertValue < 0 || insertValue > 10000 || insertValue%1 != 0){
            alert('송금액이 바르지 않습니다');
            $("#usd").val(''); //입력값 초기화 작업
            calculate_result.calculate_result = ''; //환율 계산 결과값 초기화 작업
        }else{
            $.get(`/api/currency/calculate?currency=${query}&usd=${insertValue}`, function (response) {
                calculate_result.calculate_result = '수취금액은 ' + response + ' ' + usd + ' 입니다.';
            });
        }

    });

    $("#country").change(function () {
        const query = $("#country option:selected").val();
        $.get(`/api/currency/country?country=${query}`, function (response) {
            return_api.return_api = response;
            return_api.currency = query+'/USD';
            $("#usd").val(''); //입력값 초기화 작업
            calculate_result.calculate_result = ''//환율 계산 결과값 초기화 작업
        });
    });

    $(document).ready(function () {
        const query = $("#country option:selected").val();
        $.get(`/api/currency/country?country=${query}`, function (response) {
            return_api.return_api = response;
            return_api.currency = query+'/USD';
        });
    });

})(jQuery);