<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<title>Form AJAX JSON</title>
</head>
<body>
	<form action="json_answer.php">
		<p id="js-hello"></p>
		<p>Имя: <input type="text" name="firstname"></p>
		<p>Фамилия: <input type="text" name="lastname"></p>
		<p><input type="submit" id="btn-submit" name="" value="Поздороваться!"></p>
	</form>
	<script type="text/javascript">
		// Назначаем обработчики, после полной загрузки страницы
		$(function() {

			// Обработчик нажатия на кнопку submit
			$('input[type=submit]').on('click', function(e){

				// Предотвращаем обычное поведение элемента
				e.preventDefault();

				// Формируем JSON из полей формы
				var json_obj = {
					firstname: $('input[name = firstname]').val(),
					lastname: $('input[name = lastname]').val()
				} 

				// Отправляем асинхронный ajax запрос
				// по адресу указанному в атрибуте action формы
				$.ajax({
					url: $('form').prop('action'),
					method: 'POST',
					data: 'json_to_send=' + JSON.stringify(json_obj)
				})
				// В случае успешного выполнения ответа выполняем действие
				.done(function(msg){
					// Заменяем надпись Здравствуйте в поле p#js-hello
					$('#js-hello').html(msg);
				});

			});
		});
	</script>
</body>
</html>