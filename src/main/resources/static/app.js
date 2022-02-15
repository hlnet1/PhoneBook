$('#loadEntries').click(() => {
    $('#entries-container').empty();
    $('#contacts-container').empty();
    fetch('http://localhost:8080/entries').then(response => response.json()).
    then(json => json.forEach((entry, idx) => {
// console.log(entry.firstName,entry.lastName);

        let tableRow = '<tr>' +
            // '<td>'+ entries.id + '</td>' +
            '<td>' + entry.firstName + '</td>' +
            '<td>' + entry.lastName + '</td>' +
            '<td><botton class="entry-btn" data-entry-id="' + entry.id + '"> Show Contacts </botton></td>' +
            '<td><botton class="delete-btn" data-entry-id="' + entry.id + '"> Delete </botton></td>' +
            '<td><botton class="edit-btn" data-entry-id="' + entry.id + '"> Edit </botton></td>' +
            '</tr>'

        $('#entries-container').append(tableRow);

    }))
});
// $('body').on('click', 'button.delete-btn', function () {
//     let entryId = $(this).data('entry-id');
//     console.log("Entry id to delete is " + entryId);
// })

$('body').on('click', 'button.entry-btn', function () {
    let entryId = $(this).data('entry-id');
    console.log("Entry id is " + entryId);
    $('#contacts-container').empty();

    fetch('http://localhost:8080/entries/' + entryId + '/contacts').
    then((response) => response.json()).then((json) => json.forEach((contact, idx) => {
        console.log(contact.phoneNumber, contact.type);
        let tableRow =
            '<tr>' +
            '<td>' + contact.phoneNumber + '</td>' +
            '<td>' + contact.Type + '</td>' +
            // '<td button class="edit-btn" data-contact-id="' + contact.id + '">Edit</button></td>' +
            // '<td button class="delete-btn" data-contact-id="' + contact.id + '">Delete book</button></td>'+
            '</tr>';

        $('#contacts-container').append(tableRow);
    }))
})
// $('body').on('click', 'button.delete-btn', function () {
//     let contactId = $(this).data('contact-id');
//     console.log("Contact id to delete is " + contactId);
// })


// fetch("http://localhost:8080/books").
//   then(response => response.json()).
//   then(json => json.forEach(book => {
//     let tableRow = '<tr>' +
//           '<td>' + book.title + '</td>' +
//           '<td>' + book.author.name + '</td>' +
//           '<td>' + book.isbn+ '</td>' +
//           '<td>' +
//             '<button class="edit-btn" data-book-id="' + book.id +'">Edit</button>' +
//             '<button class="delete-btn" data-book-id="' + book.id +'">Delete</button>' +
//           '</td>' +
//         '</tr>'
//   $("#authors-container").append(tableRow)
// }))
// });
//
// $('body').on('click', 'button.delete-btn', function () {
//   let bookId = $(this).data('book-id');
//   console.log("Book id to delete is " + bookId);
//
//   fetch('http://localhost:8080/books/' + bookId, {
//     method: 'DELETE'
//   }).then(_ => reloadBooks())
// });
