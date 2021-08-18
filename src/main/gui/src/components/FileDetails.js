import React, { Component } from 'react';
import { TableRow, TableCell, Button } from '@material-ui/core';
import EditIcon from "@material-ui/icons/Edit";
import DeleteIcon from "@material-ui/icons/Delete";
import IconButton from "@material-ui/core/IconButton"
import FileService from '../service/FileService';

class FileDetails extends Component {
    deleteFile() {
        this.props.deleteFile(this.props.file.id);
    }

    render() {
        return <TableRow hover>
            <TableCell>
                {this.props.file.id}
            </TableCell>
            <TableCell>
                {this.props.file.document.documentName}
            </TableCell>
            <TableCell>
                <IconButton edge="start" color='primary' size='medium' >
                    <EditIcon color='action' />
                </IconButton>
                <IconButton edge="start" color='primary' size='medium' onClick={this.deleteFile.bind(this)} >
                    <DeleteIcon color='action' />
                </IconButton>
            </TableCell>
        </TableRow>
    }
}
export default FileDetails;