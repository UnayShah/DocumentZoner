const rootURL = ''
export async function getAllFiles() {
    const response = await fetch('/findAllFiles');
    // console.log(response)
    return await response.json();

}

export async function saveFile(data) {
    const response = await fetch(rootURL + '/saveFile', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    });
    return response.json();
}