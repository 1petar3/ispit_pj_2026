function formatDate(iso) {
    if (iso == null) return 'N/A'
    return new Date(iso).toLocaleString('sr-RS', {
        year: '2-digit',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
    })
}

function formatPrice(price) {
    if (price == null) return 'N/A'
    return new Intl.NumberFormat('sr-RS').format(price) + ' €'
}

function getListingTitle(listing) {
    if (listing == null || listing.car == null) return 'N/A'
    return listing.car.make + ' ' + listing.car.model
}

function getSellerTitle(listing) {
    if (listing == null || listing.seller == null) return 'N/A'
    return listing.seller.firstName + ' ' + listing.seller.lastName
}

function getIdFromQuery() {
    const params = new URLSearchParams(window.location.search)
    return params.get('id')
}

function toDateTimeLocal(value) {
    if (value == null) return ''
    return value.substring(0, 16)
}