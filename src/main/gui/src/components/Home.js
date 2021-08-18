import React, { Component } from 'react';
import FileDetails from "./FileDetails";
import Paper from '@material-ui/core/Paper';
import { Table, TableHead, TableContainer, TableRow, TableCell, TableBody, withStyles, Toolbar, AppBar, IconButton, Button } from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';
import { Add } from "@material-ui/icons";
import FileService from '../service/FileService';
import AddFileDialog from './AddFileDialog';

const useStyles = theme => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),
        },
    },
    input: {
        display: 'none',
    },
});

class Home extends Component {
    state = {
        fileList: [],
        loading: true,
    };

    findAllFilesShort() {
        FileService.findAllFilesShort().then(response => response.json()).then(json => {
            this.setState({ fileList: json, loading: false });
        });
    }

    deleteFile(id) {
        FileService.deleteFile(id).then(response => response.json()).then(json => {
            console.log('Deleted file with id: ' + id);
            console.log('Response: ' + json);
            this.findAllFilesShort();
        })
    }

    componentDidMount() {
        this.findAllFilesShort();
    }

    render() {
        const { classes } = this.props;
        if (this.state.loading) {
            return <p>Loading</p>
        }
        return (
            <AppBar position="static">
                <Toolbar>
                    <IconButton edge="start" color="inherit" aria-label="menu">
                        <MenuIcon />
                    </IconButton>
                    <AddFileDialog />
                </Toolbar>
                <div>

                    <TableContainer component={Paper}>
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell>Id</TableCell>
                                    <TableCell>File Name</TableCell>
                                    <TableCell>Actions</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {this.state.fileList.map((file) => <FileDetails key={file.id} file={file} deleteFile={this.deleteFile.bind(this)} />)}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </div>
            </AppBar>
        );
    }
}
export default withStyles(useStyles)(Home);