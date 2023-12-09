document.addEventListener('DOMContentLoaded', function() {
    var form = document.querySelector('form');
    var addQuestionButton = document.getElementById('add-question');
    
    addQuestionButton.addEventListener('click', function() {
        var questionIndex = form.querySelectorAll('.question').length;
        var newQuestionDiv = document.createElement('div');
        newQuestionDiv.classList.add('question');
        
        var newQuestionInput = document.createElement('input');
        newQuestionInput.type = 'text';
        newQuestionInput.name = `questions[${questionIndex}]`;
        newQuestionInput.placeholder = `Question ${questionIndex}`;
        
        var removeButton = document.createElement('button');
        removeButton.type = 'button';
        removeButton.classList.add('remove-question');
        removeButton.textContent = 'Remove';
        removeButton.addEventListener('click', function() {
            newQuestionDiv.remove();
        });
        
        newQuestionDiv.appendChild(newQuestionInput);
        newQuestionDiv.appendChild(removeButton);
        form.insertBefore(newQuestionDiv, addQuestionButton);
    });
    
    form.addEventListener('click', function(event) {
        if (event.target.classList.contains('remove-question')) {
            event.target.parentElement.remove();
        }
    });
});