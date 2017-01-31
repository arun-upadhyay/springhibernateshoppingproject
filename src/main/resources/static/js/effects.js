$(document).ready(function() {
		$('#pname').keyup(function(e) {

			var filter = $('#pname').val();
			if (filter.length >= 0) {
				loadTable(filter);
			} else {
				$('tr[id*="tr_"]').remove();
			}
		});
	});

	function loadTable(filter) {
		var url = "search-products/" + filter;
		$('#tbody').load(url, function(response, status, xhr) {

			if (status == "error") {
				var msg = "Sorry but there was an error: ";
				$("#info").html(msg + xhr.status + " " + xhr.statusText);
			}
		});

		return false;
	}
	// deleting code

	$(document)
			.ready(
					function() {
						var clickedID = "";

						$('.btn-primary')
								.click(
										function() {
											clickedID = $(this).attr('id');
											if (clickedID.startsWith("delete")) {
												$('#tbody')
														.load(
																clickedID,
																function(
																		response,
																		status,
																		xhr) {

																	if (status == "error") {
																		var msg = "Sorry but there was an error: ";
																		$(
																				"#info")
																				.html(
																						msg
																								+ xhr.status
																								+ " "
																								+ xhr.statusText);
																	}
																});
												return false;
											}

										});
					});

	// adding to checkout
	$(document)
			.ready(
					function() {
						var clickedID = "";
						$('.btn-primary')
								.click(
										function() {
											clickedID = $(this).attr('id');
											if (clickedID
													.startsWith("add-to-cart")) {
												$('#tbody')
														.load(
																clickedID,
																function(
																		response,
																		status,
																		xhr) {

																	if (status == "error") {
																		var msg = "Sorry but there was an error: ";
																		$(
																				"#info")
																				.html(
																						msg
																								+ xhr.status
																								+ " "
																								+ xhr.statusText);
																	}
																});
												return false;
											}

										});
					});