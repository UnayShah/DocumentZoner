import React, { Component } from 'react';
import { TableRow, TableCell, Button } from '@material-ui/core';
import EditIcon from "@material-ui/icons/Edit";
import IconButton from "@material-ui/core/IconButton"


class FileDetails extends Component {
    constructor(props) {
        super();
        this.state = {
            file: props.file
        }
    }

    render() {
        return <TableRow hover>
            <TableCell>
                {this.state.file.id}
            </TableCell>
            <TableCell>
                {this.state.file.document.documentName}
            </TableCell>
            <TableCell>
                <IconButton edge="start" color='primary' size='medium' >
                    <EditIcon color='action'/>
                </IconButton>
            </TableCell>
        </TableRow>
    }
}
export default FileDetails;