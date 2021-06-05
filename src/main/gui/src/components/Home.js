import React, { Component } from 'react';
import { getAllFiles, saveFile } from "./AppService";
import FileDetails from "./FileDetails";
import Paper from '@material-ui/core/Paper';
import { Table, TableHead, TableContainer, makeStyles } from '@material-ui/core';
import Toolbar from "@material-ui/core/Toolbar";
import AppBar from "@material-ui/core/AppBar";
import IconButton from "@material-ui/core/IconButton"
import MenuIcon from '@material-ui/icons/Menu';

class Home extends Component {
    state = {
        fileList: [],
        loading: true,
        classes: ''
    };

    getAllFiles = () => {
        getAllFiles().then(files => {
            // console.log(files)
            this.setState({ fileList: files, loading: false })
        });
    }
    componentDidMount() {
        // getAllFiles();
        fetch('/findAllFilesShort').then(res => res.json()).then(json => {
            this.setState({ fileList: json, loading: false });
        });
    }

    render() {
        if (this.state.loading) {
            return <p>Loading</p>
        }
        return (
            <AppBar position="static">
                <Toolbar>
                    <IconButton edge="start" color="inherit" aria-label="menu">
                        <MenuIcon />
                    </IconButton>
                </Toolbar>
                <div>

                    <TableContainer component={Paper}>
                        <Table>
                            {this.state.fileList.map((file) => <FileDetails key={file.id} file={file} />)}
                        </Table>
                    </TableContainer>
                </div>
            </AppBar>
        );
    }
}
export default Home