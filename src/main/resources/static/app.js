$('#loadEntries').click(() => {

    $('#entries-container').empty();
    $('#contacts-container').empty();


    fetch('http://localhost:8080/entries')
        .then((response) => response.json())
        .then((json) => json.forEach((entry) => {

            let tableRow =
                '<tr>' +
                '<td>' + entry.firstName + '</td>' +
                '<td>' + entry.lastName + '</td>' +
                '<td>' +
                '<button class="book-btn" data-entry-id="' + entry.id + '">Show contacts</button>' +
                '</td>' +
                '<td>' +
                '<button class="delete-btn" data-entry-id="'+entry.id +  '">Delete</button>' +
                '</td>' +
                '</tr>';

            $('#entries-container').append(tableRow);
        }));
});

$('body').on('click', 'button.book-btn', function() {
    let entryId = $(this).data('entry-id');
    console.log("entry ID is " + entryId)

    $('#contacts-container').empty();

    fetch('http://localhost:8080/contacts/'+entryId+'/contacts')
        .then((response) => response.json())
        .then((json) => json.forEach((contact) => {

            let tableRow =
                '<tr>' +
                '<td>' + contact.phoneNumber + '</td>' +
                '<td>' + contact.type + '</td>' +
                '<td>' +
                '<button class="edit-btn" data-book-id="' + contact.id +'">Update</button>' +
                '<button class="delete-btn" data-book-id="' + contact.id +'">Delete</button>' +
                '</td>' +
                '</tr>';

            $('#contacts-container').append(tableRow);
        }));

});


$('body').on('click', 'button.delete-btn', function() {
    let entryId = $(this).data('entry-id');
    console.log("Entry ID to delete is " + entryId)

    fetch('http://localhost:8080/entries/'+entryId, {
        method: 'delete'
    })
        .then(data => {
            console.log("Entry deleted!")
            $('.entries-container').empty();
            $('.contacts-container').empty();
            $('#loadEntries').click();
        })
        .catch((error) => {
            console.error('Error:', error);
            location.reload();
        });

});



