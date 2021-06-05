import React, { Component } from 'react';
import { Document, Page, pdfjs } from 'react-pdf'
import Button from "@material-ui/core/Button";
// import pdfFile from '../resources/testPDF.pdf'

class OpenFile extends Component {
    constructor(props) {
        super(props);
        pdfjs.GlobalWorkerOptions.workerSrc =
            `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.js`;
        this.state = {
            file: ' ',
            loading: true,
            pageNumber: 1,
            numPages: null,
        };
    }
    componentDidMount() {
        fetch(`/findFile/?id=${this.props.fileId}`).then(res => res.json()).then(json => {
            this.setState({ file: json, loading: false });
        });
    }

    onLoadSuccess = ({ numPages }) => {
        this.setState({ numPages });
    }

    next = () => {
        if (this.state.pageNumber < this.state.numPages)
            this.setState(prevState => ({ pageNumber: (prevState.pageNumber) + 1 }));
    }

    previous = () => {
        if (this.state.pageNumber > 1)
            this.setState(prevState => ({ pageNumber: (prevState.pageNumber) - 1 }));
    }

    render() {

        if (this.state.loading) {
            return <p>Loading</p>
        }

        const fileContent = this.state.file.document.fileContent;
        const { numPages, pageNumber } = this.state;
        if (!this.state.file.document.actualDocumentName.toLowerCase().endsWith('.pdf')) {
            const Image = ({ fileContent }) => <img src={`data:image/jpeg;base64,${fileContent}`} />
            console.log('image')
            return (
                <div>
                    <Image fileContent={fileContent} />
                </div>
            )
        }
        else {
            return (
                <div>
                    <Document file={`data:application/pdf;base64,${fileContent}`}
                        onLoadSuccess={this.onLoadSuccess}>
                        <Page pageNumber={pageNumber} />
                    </Document >
                    <div>
                        <Button variant='outlined' color='primary' onClick={this.previous}>Previous</Button>
                        <Button variant='outlined' color='primary' onClick={this.next}>Next</Button>
                    </div>
                </div>
            )
        }
    }
}
export default OpenFile;