$(document).ready(function(){

    $.ajax({
        url : "resource/menu",
        dataType : "json",
        type : 'GET',
        async : true,
        success : function(data) {
            $(".main-nav").html(data.menu);
        }
    });
    
	/************************
	/*	LAYOUT
	/************************/
	$('.top-bar').css('height', '44px');
	$('.top-bar').addClass('navbar-fixed-top');
	
	$('.bottom').css('height', $('.wrapper').outerHeight(true) - $('.top-bar').outerHeight(true));
	$('.bottom').addClass('navbar-fixed-top');
	$('.bottom').css('z-index', 1);

	$('.content-wrapper').css('min-height', '100%');

	/************************
	/*	MAIN NAVIGATION
	/************************/
	$('.main-nav').on('click', '.main-menu .js-sub-menu-toggle', function(e){

		e.preventDefault();

		// 菜单栏最小化时不处理
		if($(".left-sidebar").hasClass("minified")){
			return false;
		}
		
		var target = $(this).parent('li');
		
		$('.main-menu li.active').each(function(){
			var parents = $(target).parents('li.active');
			var self = this;
			var elem = $(self);
			
			//本节点不处理
			if(target[0] && target[0]==self){
				flag = true;
				return true;
			}
			
			var flag = false;
			parents.each(function(){
				if(this==self){
					flag = true;
					return false;
				}
			});
			// 父节点不处理
			if(flag){
				return true;
			}
			elem.find(' > a .toggle-icon').removeClass('fa-angle-down').addClass('fa-angle-left');
			elem.removeClass('active');
			elem.find(' > .sub-menu').slideToggle(300);
		});
		
		if( !target.hasClass('active')){
			target.find(' > a .toggle-icon').removeClass('fa-angle-left').addClass('fa-angle-down');
			target.addClass('active');
		}
		else {
			target.find(' > a .toggle-icon').removeClass('fa-angle-down').addClass('fa-angle-left');
			target.removeClass('active');
		} 

		target.find(' > .sub-menu').slideToggle(300);
	});

	$('.js-toggle-minified').clickToggle(
		function() {
			$('.left-sidebar').addClass('minified');
			$('.content-wrapper').addClass('expanded');

			$('.left-sidebar .sub-menu')
			.css('display', 'none')
			.css('overflow', 'hidden');

			$('.main-menu > li > a > .text').animate({
					opacity: 0
			}, 200);

			$('.sidebar-minified').find('i.fa-angle-left').toggleClass('fa-angle-right');
		},
		function() {
			$('.left-sidebar').removeClass('minified');
			$('.content-wrapper').removeClass('expanded');
			$('.main-menu > li > a > .text').animate({
				opacity: 1
			}, 600);

			$('.sidebar-minified').find('i.fa-angle-left').toggleClass('fa-angle-right');
		}
	);

	// main responsive nav toggle
	$('.main-nav-toggle').clickToggle(
		function() {
			$('.left-sidebar').slideDown(300);
		},
		function() {
			$('.left-sidebar').slideUp(300);
		}
	);


	//*******************************************
	/*	LIVE SEARCH
	/********************************************/

	$mainContentCopy = $('.main-content').clone();
	$('.searchbox input[type="search"]').keydown( function(e) {
		var $this = $(this);
		
		setTimeout(function() {
			var query = $this.val();
			
			if( query.length > 2 ) {
				var regex = new RegExp(query, "i");
				var filteredWidget = [];

				$('.widget-header h3').each( function(index, el){
					var matches = $(this).text().match(regex);

					if( matches != "" && matches != null ) {
						filteredWidget.push( $(this).parents('.widget') );
					}
				});

				if( filteredWidget.length > 0 ) {
					$('.main-content .widget').hide();
					$.each( filteredWidget, function(key, widget) {
						widget.show();
					});
				}else{
					console.log('widget not found');
				}
			}else {
				$('.main-content .widget').show();
			}
		}, 0);
	});

	// widget remove
	$('.widget .btn-remove').click(function(e){

		e.preventDefault();
		$(this).parents('.widget').fadeOut(300, function(){
			$(this).remove();
		});
	});

	// widget toggle expand
	$('.widget .btn-toggle-expand').clickToggle(
		function(e) {
			e.preventDefault();
			$(this).parents('.widget').find('.widget-content').slideUp(300);
			$(this).find('i.fa-chevron-up').toggleClass('fa-chevron-down');
		},
		function(e) {
			e.preventDefault();
			$(this).parents('.widget').find('.widget-content').slideDown(300);
			$(this).find('i.fa-chevron-up').toggleClass('fa-chevron-down');
		}
	);

	// widget focus
	$('.widget .btn-focus').clickToggle(
		function(e) {
			e.preventDefault();
			$(this).find('i.fa-eye').toggleClass('fa-eye-slash');
			$(this).parents('.widget').find('.btn-remove').addClass('link-disabled');
			$(this).parents('.widget').addClass('widget-focus-enabled');
			$('<div id="focus-overlay"></div>').hide().appendTo('body').fadeIn(300);

		},
		function(e) {
			e.preventDefault();
			$theWidget = $(this).parents('.widget');
			
			$(this).find('i.fa-eye').toggleClass('fa-eye-slash');
			$theWidget.find('.btn-remove').removeClass('link-disabled');
			$('body').find('#focus-overlay').fadeOut(function(){
				$(this).remove();
				$theWidget.removeClass('widget-focus-enabled');
			});
		}
	);


	/************************
	/*	WINDOW RESIZE
	/************************/

	$(window).bind("resize", resizeResponse);

	function resizeResponse() {

		if( $(window).width() < (992-15)) {
			if( $('.left-sidebar').hasClass('minified') ) {
				$('.left-sidebar').removeClass('minified');
				$('.left-sidebar').addClass('init-minified');
			}

		}else {
			if( $('.left-sidebar').hasClass('init-minified') ) {
				$('.left-sidebar')
				.removeClass('init-minified')
				.addClass('minified');
			}
		}
		
		multiIframeTabs&&multiIframeTabs.resetIframeHeight();
	}


	/************************
	/*	BOOTSTRAP TOOLTIP
	/************************/

	$('body').tooltip({
		selector: "[data-toggle=tooltip]",
		container: "body"
	});


	/************************
	/*	BOOTSTRAP ALERT
	/************************/

	$('.alert .close').click( function(e){
		e.preventDefault();
		$(this).parents('.alert').fadeOut(300);
	});


	/************************
	/*	BOOTSTRAP POPOVER
	/************************/

	$('.btn-help').popover({
		container: 'body',
		placement: 'top',
		html: true,
		trigger: 'hover',
		title: '<i class="fa fa-book"></i> Quick Help',
		content: "Help summary goes here. Options can be passed via data attributes <code>data-</code> or JavaScript. You can change the popover trigger to 'click' instead of 'hover'."
	});

	$('.demo-popover1 #popover-title').popover({
		html: true,
		title: '<i class="fa fa-cogs"></i> Popover Title',
		content: 'This popover has title and support HTML content. Quickly implement process-centric networks rather than compelling potentialities. Objectively reinvent competitive technologies after high standards in process improvements. Phosfluorescently cultivate 24/365.'
	});

	$('.demo-popover1 #popover-hover').popover({
		html: true,
		title: '<i class="fa fa-cogs"></i> Popover Title',
		trigger: 'hover',
		content: 'Activate the popover on hover. Objectively enable optimal opportunities without market positioning expertise. Assertively optimize multidisciplinary benefits rather than holistic experiences. Credibly underwhelm real-time paradigms with.'
	});

	$('.demo-popover2 .btn').popover();


	/*****************************
	/*	WIDGET WITH AJAX ENABLE
	/*****************************/

	$('.widget-header-toolbar .btn-ajax').click( function(e){
		e.preventDefault();
		$theButton = $(this);

		$.ajax({
			url: 'php/widget-ajax.php',
			type: 'POST',
			dataType: 'json',
			cache: false,
			beforeSend: function(){
				$theButton.prop('disabled', true);
				$theButton.find('i').removeClass().addClass('fa fa-spinner fa-spin');
				$theButton.find('span').text('Loading...');
			},
			success: function( data, textStatus, XMLHttpRequest ) {
				
				setTimeout( function() {
					getResponseAction($theButton, data['msg']);
				}, 1000 );
				/* setTimeout is used for demo purpose only */

			},
			error: function( XMLHttpRequest, textStatus, errorThrown ) {
				console.log("AJAX ERROR: \n" + errorThrown);
			}
		});
	});

	function getResponseAction(theButton, msg){

		$('.widget-ajax .alert').removeClass('alert-info').addClass('alert-success')
		.find('span').text( msg );

		$('.widget-ajax .alert').find('i').removeClass().addClass('fa fa-check-circle');

		theButton.prop('disabled', false);
		theButton.find('i').removeClass().addClass('fa fa-floppy-o');
		theButton.find('span').text('Update');
	}


	//*******************************************
	/*	WIDGET QUICK NOTE
	/********************************************/

	if($('.quick-note-create').length > 0) {
		$('.quick-note-create').focusin( function() {
			$(this).find('textarea').attr('rows', 7);
			$(this).find('.title').show();
			$(this).find('.widget-footer').show();
		}).focusout( function() {
			$(this).find('textarea').attr('rows', 1);
			$(this).find('.title').hide();
			$(this).find('.widget-footer').hide();
		});
	}

	if($('.quick-note-saved').length > 0) {
		$('.quick-note-saved').click( function() {
			$('#quick-note-modal').modal();
		});
	}

	if($('.quick-note-edit').length > 0) {
		$('.quick-note-edit .btn-save').click( function() {
			$('#quick-note-modal').modal('hide');
		});
	}


	//*******************************************
	/*	WIDGET SLIM SCROLL
	/********************************************/

	if( $('.widget-scrolling').length > 0) {
		$('.widget-scrolling .widget-content').slimScroll({
			height: '410px',
			wheelStep: 5,
		});
	}


	//*******************************************
	/*	WIDGET WITH AJAX STATE
	/********************************************/

	if($('#btn-ajax-state').length > 0) {
		$('#btn-ajax-state').click( function() {
			$statusPlaceholder = $(this).parents('.widget').find('.process-status');
			ajaxCallToDo($statusPlaceholder);
		});
	}


	/**************************************
	/*	MULTISELECT/SINGLESELECT DROPDOWN
	/**************************************/

	if( $('.widget-header .multiselect').length > 0 ) {

		$('.widget-header .multiselect').multiselect({
			dropRight: true,
			buttonClass: 'btn btn-warning btn-sm'
		});
	}


	//*******************************************
	/*	DASHBOARD REMINDER
	/********************************************/

	if( $('.today-reminder').length > 0 ) {
		var count = 0;
		var timer = null;
		var ringSound = new Audio();

		if ( navigator.userAgent.match("Firefox/") ) {
			ringSound.src = "common/audio/bell-ringing.ogg";
		}else {
			ringSound.src = "common/audio/bell-ringing.mp3";
		}
		
		function ringIt() {
			if( count < 3)	{ // adjust it with the css ring animation at .today-reminder

				// sound setting saved on localStorage as 0 or 1, by default sound on (null value on localStorage)
				$globalVolume = localStorage.getItem('global-volume');

				if( ($globalVolume == null || $globalVolume == '1' ) ) {
					ringSound.play();
				}

				timer = setTimeout( ringIt, 8000); // adjust it with the css ring animation at .today-reminder
				count++;
			} else {
				if(timer != null){
					clearTimeout(timer);
				}
			}
		}

		ringIt();
	}


	//*******************************************
	/*	SWITCH INIT
	/********************************************/

	if( $('.bs-switch').length > 0 ) {
		$('.bs-switch').bootstrapSwitch();
	}


	//*******************************************
	/*	BOOTSTRAP TOUR
	/********************************************/

	var kingTour = new Tour({
		//basePath: "edit/basepath/see/doc/", // please see documentation for this setting
		basePath: contextPath,
		steps: [
			{	
				element: ".logo",
				title: "功能介绍",
				content: "系统LOGO",
				placement: "bottom",
				backdrop: true
			},
			{
				element: ".sidebar-minified",
				title: "功能介绍",
				content: "支持菜单栏最小化"
			},
			{
				element: "#multi-iframe-tabs .nav-tabs li:last",
				title: "功能介绍",
				content: "支持多TAB页",
				placement: "bottom"
			},
			{
				element: ".logged-user",
				title: "功能介绍",
				content: "自定义界面风格设置",
				placement: "left",
				backdrop: true
			},
			{
				element: "#start-tour",
				title: "功能介绍",
				content: "自动介绍功能开始/重新开始按钮",
				placement: "bottom",
				backdrop: true
			}
		],
		template: "<div class='popover tour'> " +
						"<div class='arrow'></div> " +
						"<h3 class='popover-title'></h3>" +
						"<div class='popover-content'></div>" +
						"<div class='popover-navigation' nowrap style='display: inline'>" +
							"<button class='btn btn-default' data-role='prev'>上一步</button>" +
							"<button class='btn btn-primary' data-role='next'>下一步</button>" +
							"<button class='btn btn-default' data-role='end'>结束</button>" +
						"</div>" +
					"</div>",
		onEnd: function(tour) {
			$('#start-tour').prop('disabled', false);
		}
	});


	/************************
	/*	TOP BAR
	/************************/

	if( $('.top-general-alert').length > 0 ) {

		if(localStorage && localStorage.getItem('general-alert') == null) {
			$('.top-general-alert').delay(800).slideDown('medium');
			$('.top-general-alert .close').click( function() {
				$(this).parent().slideUp('fast');
				localStorage.setItem('general-alert', 'closed');
			});
		}
	}

	// kingTour.init();

	$('#start-tour').click( function() {
		if(kingTour.ended()) {
			kingTour.restart();
		}else {
			kingTour.start();
		}

		$(this).prop('disabled', true);
	});

	$btnGlobalvol = $('.btn-global-volume');
	$theIcon = $btnGlobalvol.find('i');

	// check global volume setting for each loaded page
	if(localStorage){
	    checkGlobalVolume($theIcon, localStorage.getItem('global-volume'));
  }

	$btnGlobalvol.click( function() {
			var currentVolSetting = localStorage.getItem('global-volume');
			// default volume: 1 (on)
			if(currentVolSetting == null || currentVolSetting == "1") {
				localStorage.setItem('global-volume', 0);
			} else {
				localStorage.setItem('global-volume', 1);
			}

			checkGlobalVolume($theIcon, localStorage.getItem('global-volume'));
		}
	);

	function checkGlobalVolume(iconElement, vSetting) {
		if(vSetting == null || vSetting == "1") {
			iconElement.removeClass('fa-volume-off').addClass('fa-volume-up');
		} else {
			iconElement.removeClass('fa-volume-up').addClass('fa-volume-off');
		}
	}


	//*******************************************
	/*	SELECT2
	/********************************************/

	if( $('.select2').length > 0) {
		$('.select2').select2();
	}

	if( $('.select2-multiple').length > 0) {
		$('.select2-multiple').select2();
	}


	//*******************************************
	/*	DRAG & DROP TO-DO LIST
	/********************************************/

	if( $('.todo-list').length > 0 ) {
		$('#dragdrop-todo').sortable({
			revert: true,
			placeholder: "ui-state-highlight",
			handle: '.handle',
			update: function() {
				$status = $(this).parents('.widget').find('.process-status');
				ajaxCallToDo($status);
			}
		});

		$('.todo-list input').change( function() {
			if( $(this).prop('checked') ) {
				$(this).parents('li').addClass('completed');
			}else {
				$(this).parents('li').removeClass('completed');
			}

			$status = $(this).parents('.widget').find('.process-status');
			ajaxCallToDo($status);
		});

		function ajaxCallToDo($status) {
			$.ajax({
				url: 'php/widget-ajax.php',
				type: 'POST',
				dataType: 'json',
				cache: false,
				beforeSend: function(){
					$status.find('.loading').fadeIn(300);
				},
				success: function( data, textStatus, XMLHttpRequest ) {

					setTimeout( function() {
						$status.find('span').hide();
						$status.find('.saved').fadeIn(300);
						console.log("AJAX SUCCESS");
					}, 1000 );

					setTimeout( function() {
						$status.find('.saved').fadeOut(300);
					}, 2000 );
					/* all setTimeout is used for demo purpose only */

				},
				error: function( XMLHttpRequest, textStatus, errorThrown ) {
					$status.find('span').hide();
					$status.find('.failed').addClass('active');
					console.log("AJAX ERROR: \n" + errorThrown);
				}
			});
		}
	}

	function ajaxCallToDo($status) {
		$.ajax({
			url: 'php/widget-ajax.php',
			type: 'POST',
			dataType: 'json',
			cache: false,
			beforeSend: function(){
				$status.find('.loading').fadeIn(300);
			},
			success: function( data, textStatus, XMLHttpRequest ) {

				setTimeout( function() {
					$status.find('span').hide();
					$status.find('.saved').fadeIn(300);
					console.log("AJAX SUCCESS");
				}, 1000 );

				setTimeout( function() {
					$status.find('.saved').fadeOut(300);
				}, 2000 );
				/* all setTimeout is used for demo purpose only */

			},
			error: function( XMLHttpRequest, textStatus, errorThrown ) {
				$status.find('span').hide();
				$status.find('.failed').addClass('active');
				console.log("AJAX ERROR: \n" + errorThrown);
			}
		});
	}

});

// toggle function
$.fn.clickToggle = function( f1, f2 ) {
	return this.each( function() {
		var clicked = false;
		$(this).bind('click', function() {
			if(clicked) {
				clicked = false;
				return f2.apply(this, arguments);
			}
			clicked = true;
			return f1.apply(this, arguments);
		});
	});
};