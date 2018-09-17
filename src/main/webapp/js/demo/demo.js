var dtp = $('#datepicker').datepicker().on('changeDate', function(e) {
    dtp.datepicker('hide');
});

$('#daterange-default').daterangepicker();