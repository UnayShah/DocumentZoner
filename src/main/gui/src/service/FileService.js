const rootURL = '';
class FileService {

    params(params) {
        var requestParams = '?';
        Object.keys(params).forEach(key => requestParams += key + '=' + params[key]);
        return requestParams;
    }

    findAllFilesShort() {
        return fetch('/findAllFilesShort');
    }

    deleteFile(id) {
        return fetch(rootURL + '/deleteFile' + this.params({'id':id}), {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
        });
    }
}
export default new FileService();