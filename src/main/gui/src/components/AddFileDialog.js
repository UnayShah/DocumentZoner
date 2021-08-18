import React, { Component } from 'react';
import { Button, Dialog, DialogTitle, DialogContent, DialogContentText } from "@material-ui/core";
import { Add } from '@material-ui/icons';

class AddFileDialog extends Component {
    constructor(props) {
        super(props);
        this.state = {
            open: false
        }
        this.setOpen = this.setOpen.bind(this);
    }

    setOpen() {
        this.setState(prevState => ({ open: !prevState.open }));
    }
    render() {
        return <div>
            <Button variant="contained" color="primary" component="span" startIcon={<Add />} onClick={this.setOpen}>
                Add File
            </Button>
            <Dialog open={this.state.open} onClose={this.setOpen} disableBackdropClick>
                <DialogTitle>
                    Upload File
                </DialogTitle>
                <DialogContent>
                    hjkasdhjlkdhljkjsghiuhk
                </DialogContent>
                <Button onClick={this.setOpen}>Close</Button>
                <Button>Save</Button>
            </Dialog>
        </div>
    }
}
export default AddFileDialog;
{/* <input
                        accept="image/*"
                        className={classes.input}
                        id="contained-button-file"
                        multiple
                        type="file"
                    />
                    <label htmlFor="contained-button-file"> */}

{/* </label> */ }