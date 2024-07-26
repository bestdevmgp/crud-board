document.addEventListener("DOMContentLoaded", function() {
    const deleteButton = document.querySelector(".btn-delete");

    if (deleteButton) {
        deleteButton.addEventListener("click", function(event) {
            event.preventDefault(); // Prevent the default link behavior

            const postId = deleteButton.getAttribute("data-id");
            const confirmDelete = confirm("삭제하시겠습니까?");

            if (confirmDelete) {
                window.location.href = `/board/delete/${postId}`;
            }
        });
    }
});