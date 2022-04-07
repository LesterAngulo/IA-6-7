import {
  FormControl,
  FormHelperText,
  InputLabel,
  MenuItem,
  Select,
  TextField,
} from '@mui/material';
import React, { useEffect, useState } from 'react';

export const Selector = ({
  data,
  propName,
  handleSelected,
  defaultValue = '',
  label = '',
  Cid,
  byID = false,
  Width = 400,
  disabled = false,
  val = undefined,
  showId = false,
  reset = undefined,
}) => {
  const [Dato, setDato] = useState(null);
  const value = (item) => {
    if (byID) return item.id;
    return item;
  };
  function removeDuplicates(originalArray, prop) {
    var newArray = [];
    var lookupObject = {};

    for (var i in originalArray) {
      lookupObject[originalArray[i][prop]] = originalArray[i];
    }

    for (i in lookupObject) {
      newArray.push(lookupObject[i]);
    }
    return newArray;
  }
  let DatosProcesados = removeDuplicates(data, Cid);
  useEffect(() => {
    if (data.length === 1) {
      handleSelected({
        target: { value: data[0], name: propName, id: data[0].id },
      });
      setDato(data[0].id);
    }
  }, []);

  const handleChange = (e) => {
    setDato(e.target.value);
    e.target.name = propName;
    handleSelected(e);
  };

  return (
    <FormControl
      fullWidth={Width === 'full' ? true : false}
      focused={
        label === 'Casino' && val === undefined && data.length > 0
          ? true
          : false
      }
      style={{ minWidth: Width === 'full' ? false : Width }}
    >
      {data.length > 1 ? (
        <>
          <InputLabel id='demo-simple-select-label'>{label}</InputLabel>
          <Select
            style={{ height: 55 }}
            variant='outlined'
            label={label}
            value={
              val === undefined && reset === true ? null : Dato ?? defaultValue
            }
            onChange={handleChange}
            disabled={disabled}
          >
            {DatosProcesados.map((item) => (
              <MenuItem key={item.id} value={value(item)}>
                {showId ? item.id + ' ' : undefined}
                {item[Cid] === null ? 'sin nombre' : '' + item[Cid]}
              </MenuItem>
            ))}
          </Select>
        </>
      ) : data.length > 0 && data[0].hasOwnProperty('name') ? (
        <TextField label={label} defaultValue={data[0].name} disabled={true} />
      ) : (
        <TextField label={label} disabled={true} />
      )}

      {label === 'Casino' &&
        val === undefined &&
        data.length > 1 &&
        disabled === false && (
          <FormHelperText id='my-helper-text'>
            favor de seleccionar casino
          </FormHelperText>
        )}
    </FormControl>
  );
};
