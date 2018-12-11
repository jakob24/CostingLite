$(document).ready(function() {

	$('.ui-menuitem-link').each(function() {
		if (window.location.pathname.indexOf($(this).attr('href')) != -1) {
			$(this).css('font-weight', 'bold');// or add class
		}
	});

});

function showHelp() 
{
	var pagePrefix = "http://samplewebpath/acmeapplication/webhelp/index.htm#";
	var helpExtension = ".htm";
	var pageName = window.location.pathname;
	pageName = pageName.substring(pageName.lastIndexOf('/') + 1);
	var pageExtension = pageName.substring(pageName.lastIndexOf('.'));
	pageName = pagePrefix + pageName.replace(pageExtension, helpExtension);
	myWindow = window.open(pageName,"tinyWindow",
					'scrollbars=yes,menubar=no,height=600,width=600,resizable=yes,toolbar=no,location=no,status=no');
	myWindow.focus();
}

function alignTandC()
{
	var tandcForm = document.forms["dialogForm"];
	var htmlTag = document.getElementById('dialogForm:confirmDialog');
	htmlTag.style.height = Math.floor(window.innerHeight*0.9)+"px";
}